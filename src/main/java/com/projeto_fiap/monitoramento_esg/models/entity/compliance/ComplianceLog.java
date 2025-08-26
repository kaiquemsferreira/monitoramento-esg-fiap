package com.projeto_fiap.monitoramento_esg.models.entity.compliance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "compliance_logs")
public class ComplianceLog {
    @Id
    private String id;
    private String userId;
    private String action;
    private String entity;
    private String entityId;
    private Instant timestamp;
    private String notes;
    private List<Attachment> attachments;
}
