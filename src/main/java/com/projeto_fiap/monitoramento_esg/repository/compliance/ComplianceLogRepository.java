package com.projeto_fiap.monitoramento_esg.repository.compliance;

import com.projeto_fiap.monitoramento_esg.models.entity.compliance.ComplianceLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplianceLogRepository extends MongoRepository<ComplianceLog, String> {

    @Query("""
           {
             $and: [
               { $or: [ { 'action': ?0 }, { ?0: { $exists: false } } ] },
               { $or: [ { 'entity': ?1 }, { ?1: { $exists: false } } ] },
               { $or: [ { 'entityId': ?2 }, { ?2: { $exists: false } } ] }
             ]
           }
           """)
    Page<ComplianceLog> search(String action, String entity, String entityId, Pageable pageable);
}
