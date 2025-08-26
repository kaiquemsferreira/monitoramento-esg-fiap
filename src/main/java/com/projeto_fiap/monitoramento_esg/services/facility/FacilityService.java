package com.projeto_fiap.monitoramento_esg.services.facility;

import com.projeto_fiap.monitoramento_esg.mappers.FacilityMapper;
import com.projeto_fiap.monitoramento_esg.models.dto.facility.FacilityDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.facility.Facility;
import com.projeto_fiap.monitoramento_esg.repository.facility.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacilityService {
    private final FacilityRepository facilityRepository;
    private final FacilityMapper facilityMapper;

    public Page<FacilityDTO> list(Pageable pageable) {
        return this.facilityRepository.findAll(pageable)
                .map(facilityMapper::convertFacilityToFacilityDTO);
    }

    public FacilityDTO get(String id) {
        Facility facility = this.facilityRepository.findById(id).orElseThrow();
        return this.facilityMapper.convertFacilityToFacilityDTO(facility);
    }

    public FacilityDTO create(FacilityDTO input) {
        Facility facility = this.facilityMapper.convertFacilityDTOToFacility(input);
        Facility savedFacility = this.facilityRepository.save(facility);
        return this.facilityMapper.convertFacilityToFacilityDTO(savedFacility);
    }

    public FacilityDTO update(String id, FacilityDTO input) {
        input.setId(id);
        Facility facility = this.facilityMapper.convertFacilityDTOToFacility(input);
        Facility savedFacility = this.facilityRepository.save(facility);
        return this.facilityMapper.convertFacilityToFacilityDTO(savedFacility);
    }

    public void delete(String id) {
        this.facilityRepository.deleteById(id);
    }
}
