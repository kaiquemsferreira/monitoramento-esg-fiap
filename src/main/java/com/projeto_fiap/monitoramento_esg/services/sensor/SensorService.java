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
        return this.sensorRepository.findById(ObjectIdUtil.parseOrNull(id))
                .map(this.sensorMapper::toDto)
                .orElseThrow(() -> new SensorNotFoundException(SENSOR_NOT_FOUND_WITH_ID + id));
    }


    public SensorDTO create(SensorDTO input) {
        input.setId(null);
        Sensor sensor = this.sensorMapper.toEntity(input);
        Sensor saved = this.sensorRepository.insert(sensor);
        return this.sensorMapper.toDto(saved);
    }

    public SensorDTO update(String id, SensorDTO input) {
        input.setId(id);
        Sensor sensor = this.sensorMapper.toEntity(input);
        Sensor savedSensor = this.sensorRepository.save(sensor);
        return this.sensorMapper.toDto(savedSensor);
    }

    public void delete(String id) {
        this.sensorRepository.deleteById(ObjectIdUtil.parseOrNull(id));
    }
}
