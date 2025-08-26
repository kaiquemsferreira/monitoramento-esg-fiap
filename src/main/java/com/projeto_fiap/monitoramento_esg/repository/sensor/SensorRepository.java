package com.projeto_fiap.monitoramento_esg.repository.sensor;

import com.projeto_fiap.monitoramento_esg.models.entity.sensor.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends MongoRepository<Sensor, String> {
    Page<Sensor> findByFacilityId(String facilityId, Pageable pageable);
}
