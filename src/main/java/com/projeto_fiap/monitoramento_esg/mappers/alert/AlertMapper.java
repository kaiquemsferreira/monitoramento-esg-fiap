package com.projeto_fiap.monitoramento_esg.mappers.alert;

import com.projeto_fiap.monitoramento_esg.models.dto.alert.AlertDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.alert.Alert;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class AlertMapper {

    public AlertDTO convertAlertToAlertDTO(Alert entity) {
        return AlertDTO
                .builder()
                .id(entity.getId())
                .type(entity.getType())
                .level(entity.getLevel())
                .sensorId(entity.getSensorId())
                .threshold(entity.getThreshold())
                .period(entity.getPeriod())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .resolvedAt(entity.getResolvedAt())
                .actions(entity.getActions())
                .build();
    }

    public Alert convertAlertDTOToAlert(AlertDTO dto) {
        return Alert
                .builder()
                .id(dto.getId())
                .type(dto.getType())
                .level(dto.getLevel())
                .sensorId(dto.getSensorId())
                .threshold(dto.getThreshold())
                .period(dto.getPeriod())
                .status(dto.getStatus())
                .createdAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : Instant.now())
                .resolvedAt(Instant.now())
                .actions(dto.getActions())
                .build();
    }
}
