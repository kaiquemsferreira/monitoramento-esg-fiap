package com.projeto_fiap.monitoramento_esg.mappers.sensor;

import com.projeto_fiap.monitoramento_esg.models.dto.sensor.SensorDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.sensor.Sensor;
import com.projeto_fiap.monitoramento_esg.utils.ObjectIdUtil;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper {
    public SensorDTO toDto(Sensor e) {
        return SensorDTO.builder()
                .id(ObjectIdUtil.toString(e.getId()))
                .name(e.getName())
                .type(e.getType())
                .facilityId(ObjectIdUtil.toString(e.getFacilityId()))
                .active(e.getActive())
                .tags(e.getTags())
                .specs(e.getSpecs())
                .build();
    }

    public Sensor toEntity(SensorDTO d) {
        return Sensor.builder()
                .id(ObjectIdUtil.parseOrNull(d.getId()))
                .name(d.getName())
                .type(d.getType() != null ? d.getType().toLowerCase() : null)
                .facilityId(ObjectIdUtil.parseOrNull(d.getFacilityId()))
                .active(d.getActive() != null ? d.getActive() : Boolean.TRUE)
                .tags(d.getTags())
                .specs(d.getSpecs())
                .build();
    }
}
