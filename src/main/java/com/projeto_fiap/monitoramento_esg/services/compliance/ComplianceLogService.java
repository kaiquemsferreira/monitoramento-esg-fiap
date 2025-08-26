package com.projeto_fiap.monitoramento_esg.services.compliance;

import com.projeto_fiap.monitoramento_esg.exceptions.ComplianceLogNotFoundException;
import com.projeto_fiap.monitoramento_esg.mappers.compliance.ComplianceLogMapper;
import com.projeto_fiap.monitoramento_esg.models.dto.compliance.ComplianceLogDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.compliance.ComplianceLog;
import com.projeto_fiap.monitoramento_esg.repository.compliance.ComplianceLogRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.projeto_fiap.monitoramento_esg.constants.MensagensConstantes.COMPLIANCE_LOG_NOT_FOUND_WITH_ID;

@Service
@RequiredArgsConstructor
public class ComplianceLogService {
    private final ComplianceLogRepository complianceLogRepository;
    private final ComplianceLogMapper complianceLogMapper;

    public Page<ComplianceLogDTO> list(String action, String entity, String entityId, Pageable pageable) {
        return this.complianceLogRepository.search(
                StringUtils.trimToNull(action),
                StringUtils.trimToNull(entity),
                StringUtils.trimToNull(entityId),
                pageable
        ).map(this.complianceLogMapper::convertComplianceLogToComplianceLogDTO);
    }

    public ComplianceLogDTO get(String id) {
        return this.complianceLogRepository.findById(id)
                .map(this.complianceLogMapper::convertComplianceLogToComplianceLogDTO)
                .orElseThrow(() -> new ComplianceLogNotFoundException(COMPLIANCE_LOG_NOT_FOUND_WITH_ID + id));
    }

    public ComplianceLogDTO create(ComplianceLogDTO input) {
        ComplianceLog complianceLog = this.complianceLogMapper.convertComplianceLogDTOToComplianceLog(input);
        ComplianceLog savedComplianceLog = this.complianceLogRepository.save(complianceLog);
        return this.complianceLogMapper.convertComplianceLogToComplianceLogDTO(savedComplianceLog);
    }

    public ComplianceLogDTO update(String id, ComplianceLogDTO input) {
        input.setId(id);
        ComplianceLog complianceLog = this.complianceLogMapper.convertComplianceLogDTOToComplianceLog(input);
        ComplianceLog savedComplianceLog = this.complianceLogRepository.save(complianceLog);
        return this.complianceLogMapper.convertComplianceLogToComplianceLogDTO(savedComplianceLog);
    }

    public void delete(String id) {
        this.complianceLogRepository.deleteById(id);
    }
}
