package com.projeto_fiap.monitoramento_esg.models.dto.sensor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class SensorDTO {
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @NotBlank
    private String facilityId;

    @NotNull
    private Boolean active;

    private List<String> tags;
    private Map<String, Object> specs;
}
