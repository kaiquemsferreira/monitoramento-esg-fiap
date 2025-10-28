package com.projeto_fiap.monitoramento_esg.mappers.compliance;

import com.projeto_fiap.monitoramento_esg.models.dto.compliance.ComplianceLogDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.compliance.ComplianceLog;
import com.projeto_fiap.monitoramento_esg.utils.ObjectIdUtil;
import org.springframework.stereotype.Component;

@Component
public class ComplianceLogMapper {

    public ComplianceLogDTO toDto(ComplianceLog e) {
        return ComplianceLogDTO.builder()
                .id(ObjectIdUtil.toString(e.getId()))
                .userId(e.getUserId())
                .action(e.getAction())
                .entity(e.getEntity())
                .entityId(e.getEntityId())
                .timestamp(e.getTimestamp())
                .notes(e.getNotes())
                .attachments(e.getAttachments())
                .build();
    }

    public ComplianceLog toEntity(ComplianceLogDTO d) {
        return ComplianceLog.builder()
                .id(ObjectIdUtil.parseOrNull(d.getId()))
                .userId(d.getUserId())
                .action(d.getAction())
                .entity(d.getEntity())
                .entityId(d.getEntityId())
                .timestamp(d.getTimestamp())
                .notes(d.getNotes())
                .attachments(d.getAttachments())
                .build();
    }
}
