package com.projeto_fiap.monitoramento_esg.models.entity.sensor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String id;
    private String name;
    private String type;
    @Field(targetType = FieldType.OBJECT_ID)
    private String facilityId;
    private Boolean active;
    private List<String> tags;
    private Map<String, Object> specs;
}
