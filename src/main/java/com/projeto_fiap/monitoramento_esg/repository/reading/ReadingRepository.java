package com.projeto_fiap.monitoramento_esg.repository.reading;

import com.projeto_fiap.monitoramento_esg.models.entity.reading.Reading;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ReadingRepository extends MongoRepository<Reading, String> {

    Page<Reading> findBySensorId(String sensorId, Pageable pageable);

    Page<Reading> findBySensorIdAndTsBetween(String sensorId, Instant from, Instant to, Pageable pageable);

    List<Reading> findTop10BySensorIdOrderByTsDesc(String sensorId);
}
