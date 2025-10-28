package com.projeto_fiap.monitoramento_esg.services.sensor;

import com.projeto_fiap.monitoramento_esg.exceptions.SensorNotFoundException;
import com.projeto_fiap.monitoramento_esg.mappers.sensor.SensorMapper;
import com.projeto_fiap.monitoramento_esg.models.dto.sensor.SensorDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.sensor.Sensor;
import com.projeto_fiap.monitoramento_esg.repository.sensor.SensorRepository;
import com.projeto_fiap.monitoramento_esg.utils.ObjectIdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.projeto_fiap.monitoramento_esg.constants.MensagensConstantes.SENSOR_NOT_FOUND_WITH_ID;

@Service
@RequiredArgsConstructor
public class SensorService {
    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    public Page<SensorDTO> list(String facilityId, Pageable pageable) {
        if (facilityId != null && !facilityId.isBlank()) {
            return this.sensorRepository.findByFacilityId(ObjectIdUtil.parseOrNull(facilityId), pageable)
                    .map(this.sensorMapper::toDto);
        }
        return this.sensorRepository.findAll(pageable)
                .map(this.sensorMapper::toDto);
    }

    public SensorDTO get(String id) {
        var oid = ObjectIdUtil.parseOrNull(id);
        if (oid == null) {
            throw new SensorNotFoundException(SENSOR_NOT_FOUND_WITH_ID + id);
        }
        return this.sensorRepository.findById(oid)
                .map(this.sensorMapper::toDto)
                .orElseThrow(() -> new SensorNotFoundException(SENSOR_NOT_FOUND_WITH_ID + id));
    }


    public SensorDTO create(SensorDTO input) {
        input.setId(null);
        Sensor sensor = this.sensorMapper.toEntity(input);
        Sensor saved = this.sensorRepository.insert(sensor);
        return this.sensorMapper.toDto(saved);
    }

    public SensorDTO update(String id, SensorDTO in) {
        var oid = ObjectIdUtil.parseOrNull(id);
        if (oid == null) throw new SensorNotFoundException(SENSOR_NOT_FOUND_WITH_ID + id);

        var cur = sensorRepository.findById(oid)
                .orElseThrow(() -> new SensorNotFoundException(SENSOR_NOT_FOUND_WITH_ID + id));

        if (in.getName() != null)       cur.setName(in.getName());
        if (in.getType() != null)       cur.setType(in.getType());
        if (in.getFacilityId() != null) cur.setFacilityId(ObjectIdUtil.parseOrNull(in.getFacilityId()));
        if (in.getActive() != null)     cur.setActive(in.getActive());
        if (in.getTags() != null)       cur.setTags(in.getTags());
        if (in.getSpecs() != null)      cur.setSpecs(in.getSpecs());

        return sensorMapper.toDto(sensorRepository.save(cur));
    }

    public void delete(String id) {
        var oid = ObjectIdUtil.parseOrNull(id);
        if (oid == null) {
            throw new SensorNotFoundException(SENSOR_NOT_FOUND_WITH_ID + id);
        }
        if (!this.sensorRepository.existsById(oid)) {
            throw new SensorNotFoundException(SENSOR_NOT_FOUND_WITH_ID + id);
        }
        this.sensorRepository.deleteById(oid);
    }
}
