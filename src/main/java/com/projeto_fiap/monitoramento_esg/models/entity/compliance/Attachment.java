package com.projeto_fiap.monitoramento_esg.models.entity.compliance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Attachment {
    private String name;
    private String url;
}
