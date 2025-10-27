package com.projeto_fiap.monitoramento_esg.repository.sensor;

import com.projeto_fiap.monitoramento_esg.models.entity.sensor.Sensor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends MongoRepository<Sensor, ObjectId> {
    Page<Sensor> findByFacilityId(ObjectId facilityId, Pageable pageable);
}
