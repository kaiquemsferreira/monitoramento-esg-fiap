package com.projeto_fiap.monitoramento_esg.services.sensor;

import com.projeto_fiap.monitoramento_esg.exceptions.SensorNotFoundException;
import com.projeto_fiap.monitoramento_esg.mappers.sensor.SensorMapper;
import com.projeto_fiap.monitoramento_esg.models.dto.sensor.SensorDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.sensor.Sensor;
import com.projeto_fiap.monitoramento_esg.repository.sensor.SensorRepository;
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
            return this.sensorRepository.findByFacilityId(facilityId, pageable)
                    .map(this.sensorMapper::convertSensorToSensorDTO);
        }
        return this.sensorRepository.findAll(pageable)
                .map(this.sensorMapper::convertSensorToSensorDTO);
    }

    public SensorDTO get(String id) {
        return this.sensorRepository.findById(id)
                .map(this.sensorMapper::convertSensorToSensorDTO)
                .orElseThrow(() -> new SensorNotFoundException(SENSOR_NOT_FOUND_WITH_ID + id));
    }


    public SensorDTO create(SensorDTO input) {
        Sensor sensor = this.sensorMapper.convertSensorDTOToSensor(input);
        Sensor savedSensor = this.sensorRepository.save(sensor);
        return this.sensorMapper.convertSensorToSensorDTO(savedSensor);
    }

    public SensorDTO update(String id, SensorDTO input) {
        input.setId(id);
        Sensor sensor = this.sensorMapper.convertSensorDTOToSensor(input);
        Sensor savedSensor = this.sensorRepository.save(sensor);
        return this.sensorMapper.convertSensorToSensorDTO(savedSensor);
    }

    public void delete(String id) {
        this.sensorRepository.deleteById(id);
    }
}
