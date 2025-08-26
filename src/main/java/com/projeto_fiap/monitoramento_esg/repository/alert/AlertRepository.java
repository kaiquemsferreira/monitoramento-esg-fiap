package com.projeto_fiap.monitoramento_esg.repository.alert;

import com.projeto_fiap.monitoramento_esg.models.entity.alert.Alert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends MongoRepository<Alert, String> {

    Page<Alert> findByStatus(String status, Pageable pageable);

    Page<Alert> findBySensorId(String sensorId, Pageable pageable);

    Page<Alert> findBySensorIdAndStatus(String sensorId, String status, Pageable pageable);
}
