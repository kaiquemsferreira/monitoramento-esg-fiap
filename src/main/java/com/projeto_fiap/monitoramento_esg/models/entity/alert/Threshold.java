package com.projeto_fiap.monitoramento_esg.models.entity.alert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Threshold {
    private String operator;
    private Double value;
    private String unit;
}
