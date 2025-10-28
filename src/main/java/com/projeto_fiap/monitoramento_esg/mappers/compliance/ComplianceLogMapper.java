package com.projeto_fiap.monitoramento_esg.mappers.compliance;

import com.projeto_fiap.monitoramento_esg.models.dto.compliance.ComplianceLogDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.compliance.ComplianceLog;
import com.projeto_fiap.monitoramento_esg.utils.ObjectIdUtil;
import org.springframework.stereotype.Component;

@Component
public class ComplianceLogMapper {

    public ComplianceLogDTO toDto(ComplianceLog entity) {
        return ComplianceLogDTO
                .builder()
                .id(ObjectIdUtil.toString(entity.getId()))
                .userId(ObjectIdUtil.toString(entity.getUserId()))
                .action(entity.getAction())
                .entity(entity.getEntity())
                .entityId(entity.getEntityId())
                .timestamp(entity.getTimestamp())
                .notes(entity.getNotes())
                .attachments(entity.getAttachments())
                .build();
    }

    public ComplianceLog toEntity(ComplianceLogDTO dto) {
        return ComplianceLog
                .builder()
                .id(ObjectIdUtil.parseOrNull(dto.getId()))
                .userId(ObjectIdUtil.parseOrNull(dto.getUserId()))
                .action(dto.getAction())
                .entity(dto.getEntity())
                .entityId(dto.getEntityId())
                .timestamp(dto.getTimestamp())
                .notes(dto.getNotes())
                .attachments(dto.getAttachments())
                .build();
    }
}
