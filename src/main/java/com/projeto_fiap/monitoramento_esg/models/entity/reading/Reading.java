package com.projeto_fiap.monitoramento_esg.models.entity.reading;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;
import java.util.Map;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "readings")
public class Reading {
    @Id
    private String id;
    @Field(targetType = FieldType.OBJECT_ID)
    private String sensorId;
    private Instant ts;
    private Double kwh;
    private Map<String, Object> metadata;
    private Double temperatureC;
    private String notes;
}
