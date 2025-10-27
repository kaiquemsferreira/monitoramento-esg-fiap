package com.projeto_fiap.monitoramento_esg.models.entity.sensor;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.util.List;
import java.util.Map;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "sensors")
public class Sensor {
    @Id
    private ObjectId id;
    private String name;
    private String type;
    @Field(targetType = FieldType.OBJECT_ID)
    private ObjectId facilityId;
    private Boolean active;
    private List<String> tags;
    private Map<String, Object> specs;
}
