package com.projeto_fiap.monitoramento_esg.models.entity.alert;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "alerts")
public class Alert {
    @Id
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
