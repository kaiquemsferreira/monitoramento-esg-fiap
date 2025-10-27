package com.projeto_fiap.monitoramento_esg.mappers.alert;

import com.projeto_fiap.monitoramento_esg.models.dto.alert.AlertDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.alert.Alert;
import com.projeto_fiap.monitoramento_esg.utils.ObjectIdUtil;
import org.springframework.stereotype.Component;

@Component
public class AlertMapper {
    public AlertDTO toDto(Alert e) {
        return AlertDTO.builder()
                .id(ObjectIdUtil.toString(e.getId()))
                .type(e.getType())
                .level(e.getLevel())
                .sensorId(ObjectIdUtil.toString(e.getSensorId()))
                .message(e.getMessage())
                .threshold(e.getThreshold())
                .period(e.getPeriod())
                .status(e.getStatus())
                .createdAt(e.getCreatedAt())
                .resolvedAt(e.getResolvedAt())
                .actions(e.getActions())
                .build();
    }

    public Alert toEntity(AlertDTO d) {
        return Alert.builder()
                .id(ObjectIdUtil.parseOrNull(d.getId()))
                .type(d.getType())
                .level(d.getLevel())
                .sensorId(ObjectIdUtil.parseOrNull(d.getSensorId()))
                .message(d.getMessage())
                .threshold(d.getThreshold())
                .period(d.getPeriod())
                .status(d.getStatus())
                .createdAt(d.getCreatedAt())
                .resolvedAt(d.getResolvedAt())
                .actions(d.getActions())
                .build();
    }
}
