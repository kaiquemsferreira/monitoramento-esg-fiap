package com.projeto_fiap.monitoramento_esg.services.compliance;

import com.projeto_fiap.monitoramento_esg.exceptions.ComplianceLogNotFoundException;
import com.projeto_fiap.monitoramento_esg.mappers.compliance.ComplianceLogMapper;
import com.projeto_fiap.monitoramento_esg.models.dto.compliance.ComplianceLogDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.compliance.ComplianceLog;
import com.projeto_fiap.monitoramento_esg.repository.compliance.ComplianceLogRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplianceLogService {

    private final MongoTemplate mongoTemplate;
    private final ComplianceLogRepository repository;
    private final ComplianceLogMapper mapper;

    public Page<ComplianceLogDTO> list(String action, String entity, String entityId, Pageable pageable) {
        List<Criteria> ands = new ArrayList<>();
        if (StringUtils.isNotBlank(action))   ands.add(Criteria.where("action").is(action));
        if (StringUtils.isNotBlank(entity))   ands.add(Criteria.where("entity").is(entity));
        if (StringUtils.isNotBlank(entityId)) ands.add(Criteria.where("entityId").is(entityId));

        Query q = new Query();
        if (!ands.isEmpty()) {
            q.addCriteria(new Criteria().andOperator(ands.toArray(new Criteria[0])));
        }
        q.with(pageable); // paginação + ordenação vindas do Pageable

        long total = mongoTemplate.count(q, ComplianceLog.class);
        List<ComplianceLogDTO> content = mongoTemplate.find(q, ComplianceLog.class)
                .stream()
                .map(mapper::convertComplianceLogToComplianceLogDTO)
                .toList();

        return new PageImpl<>(content, pageable, total);
    }

    public ComplianceLogDTO get(String id) {
        return repository.findById(id)
                .map(mapper::convertComplianceLogToComplianceLogDTO)
                .orElseThrow(() -> new ComplianceLogNotFoundException("ComplianceLog not found: " + id));
    }

    public ComplianceLogDTO create(ComplianceLogDTO input) {
        ComplianceLog saved = mongoTemplate.save(mapper.convertComplianceLogDTOToComplianceLog(input));
        return mapper.convertComplianceLogToComplianceLogDTO(saved);
    }

    public ComplianceLogDTO update(String id, ComplianceLogDTO input) {
        input.setId(id);
        ComplianceLog saved = mongoTemplate.save(mapper.convertComplianceLogDTOToComplianceLog(input));
        return mapper.convertComplianceLogToComplianceLogDTO(saved);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
