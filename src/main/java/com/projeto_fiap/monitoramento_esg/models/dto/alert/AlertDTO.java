package com.projeto_fiap.monitoramento_esg.models.dto.alert;

import com.projeto_fiap.monitoramento_esg.models.entity.alert.Action;
import com.projeto_fiap.monitoramento_esg.models.entity.alert.Period;
import com.projeto_fiap.monitoramento_esg.models.entity.alert.Threshold;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class AlertDTO {
    private String id;
    private String type;
    private String level;
    private String sensorId;
    private Threshold threshold;
    private Period period;
    private String status;
    private Instant createdAt;
    private Instant resolvedAt;
    private List<Action> actions;
}
