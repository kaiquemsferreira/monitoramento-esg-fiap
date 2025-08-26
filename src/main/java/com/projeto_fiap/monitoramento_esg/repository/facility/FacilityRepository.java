package com.projeto_fiap.monitoramento_esg.repository.facility;

import com.projeto_fiap.monitoramento_esg.models.entity.facility.Facility;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacilityRepository extends MongoRepository<Facility, String> {
    List<Facility> findByAddressCity(String city);
}
