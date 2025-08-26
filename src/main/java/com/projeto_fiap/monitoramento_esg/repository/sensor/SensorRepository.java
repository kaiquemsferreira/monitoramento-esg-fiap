package com.projeto_fiap.monitoramento_esg.repository.sensor;

import com.projeto_fiap.monitoramento_esg.models.entity.sensor.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends MongoRepository<Sensor, String> {
    List<Sensor> findByFacilityIdAndActiveTrue(String facilityId);
}
