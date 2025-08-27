package com.projeto_fiap.monitoramento_esg.models.entity.alert;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.Date;
import java.util.List;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "alerts")
public class Alert {
    @Id
    private String id;
    private String type;
    private String level;
    @Field(targetType = FieldType.OBJECT_ID)
    private String sensorId;
    private Threshold threshold;
    private Period period;
    private String status;
    private Date createdAt;
    private Date resolvedAt;
    private List<Action> actions;
}
