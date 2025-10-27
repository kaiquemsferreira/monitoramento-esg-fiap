package com.projeto_fiap.monitoramento_esg.repository.alert;

import com.projeto_fiap.monitoramento_esg.models.entity.alert.Alert;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends MongoRepository<Alert, ObjectId> {
    Page<Alert> findByStatus(String status, Pageable pageable);
    Page<Alert> findBySensorId(ObjectId sensorId, Pageable pageable);
    Page<Alert> findBySensorIdAndStatus(ObjectId sensorId, String status, Pageable pageable);
}
