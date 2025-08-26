package com.projeto_fiap.monitoramento_esg.mappers.sensor;

import com.projeto_fiap.monitoramento_esg.models.dto.sensor.SensorDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.sensor.Sensor;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper {

    public SensorDTO convertSensorToSensorDTO(Sensor entity) {
        return SensorDTO
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .facilityId(entity.getFacilityId())
                .active(entity.getActive())
                .tags(entity.getTags())
                .specs(entity.getSpecs())
                .build();
    }

    public Sensor convertSensorDTOToSensor(SensorDTO dto) {
        return Sensor
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .type(dto.getType())
                .facilityId(dto.getFacilityId())
                .active(dto.getActive())
                .tags(dto.getTags())
                .specs(dto.getSpecs())
                .build();
    }
}
