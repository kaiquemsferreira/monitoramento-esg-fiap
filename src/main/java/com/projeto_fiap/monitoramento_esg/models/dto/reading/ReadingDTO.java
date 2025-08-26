package com.projeto_fiap.monitoramento_esg.models.dto.reading;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Map;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ReadingDTO {
    private String id;
    private String sensorId;
    private Instant ts;
    private Double kwh;
    private Map<String, Object> metadata;
    private Double temperatureC;
    private String notes;
}
