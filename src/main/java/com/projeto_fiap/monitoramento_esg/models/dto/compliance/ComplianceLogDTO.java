package com.projeto_fiap.monitoramento_esg.models.dto.compliance;

import com.projeto_fiap.monitoramento_esg.models.entity.compliance.Attachment;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class ComplianceLogDTO {
    private String id;
    @NotBlank
    private String userId;
    @NotBlank
    private String action;
    @NotBlank
    private String entity;
    @NotBlank
    private String entityId;
    private Instant timestamp;
    private String notes;
    private List<Attachment> attachments;
}
