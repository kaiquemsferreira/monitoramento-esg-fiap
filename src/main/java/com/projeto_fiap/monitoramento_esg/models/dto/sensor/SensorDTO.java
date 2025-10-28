package com.projeto_fiap.monitoramento_esg.models.dto.sensor;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class SensorDTO {
    private String id;
    private String name;
    private String type;
    private String facilityId;
    private Boolean active;
    private List<String> tags;
    private Map<String, Object> specs;
}
