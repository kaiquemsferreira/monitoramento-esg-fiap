package com.projeto_fiap.monitoramento_esg.repository.compliance;

import com.projeto_fiap.monitoramento_esg.models.entity.compliance.ComplianceLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplianceLogRepository extends MongoRepository<ComplianceLog, String> {

}
