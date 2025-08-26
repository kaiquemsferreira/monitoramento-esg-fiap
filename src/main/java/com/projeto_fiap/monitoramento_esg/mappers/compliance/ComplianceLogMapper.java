package com.projeto_fiap.monitoramento_esg.mappers.compliance;

import com.projeto_fiap.monitoramento_esg.models.dto.compliance.ComplianceLogDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.compliance.ComplianceLog;
import org.springframework.stereotype.Component;

@Component
public class ComplianceLogMapper {

    public ComplianceLogDTO convertComplianceLogToComplianceLogDTO(ComplianceLog entity) {
        return ComplianceLogDTO
                .builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .action(entity.getAction())
                .entity(entity.getEntity())
                .entityId(entity.getEntityId())
                .timestamp(entity.getTimestamp())
                .notes(entity.getNotes())
                .attachments(entity.getAttachments())
                .build();
    }

    public ComplianceLog convertComplianceLogDTOToComplianceLog(ComplianceLogDTO dto) {
        return ComplianceLog
                .builder()
                .id(dto.getId())
                .userId(dto.getUserId())
                .action(dto.getAction())
                .entity(dto.getEntity())
                .entityId(dto.getEntityId())
                .timestamp(dto.getTimestamp())
                .notes(dto.getNotes())
                .attachments(dto.getAttachments())
                .build();
    }
}
