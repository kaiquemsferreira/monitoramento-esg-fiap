package com.projeto_fiap.monitoramento_esg.models.entity.facility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class EsgGoals {
    private Integer year;
    private Integer energyKwhTarget;
    private Integer co2ReductionPctTarget;
}
