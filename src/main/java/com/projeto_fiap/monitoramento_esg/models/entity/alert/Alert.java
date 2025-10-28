package com.projeto_fiap.monitoramento_esg.models.entity.alert;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "alerts")
public class Alert {
    @Id
    private ObjectId id;
    @Field("type")
    private String type;
    private String level;
    private ObjectId sensorId;
    private String message;
    private Threshold threshold;
    private Period period;
    @Field("status")
    private String status;
    @CreatedDate
    @Field("createdAt")
    private Date createdAt;
    private Date resolvedAt;
    private List<Action> actions;
}
