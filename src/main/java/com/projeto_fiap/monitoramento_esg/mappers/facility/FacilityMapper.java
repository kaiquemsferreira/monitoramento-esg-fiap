package com.projeto_fiap.monitoramento_esg.mappers.facility;

import com.projeto_fiap.monitoramento_esg.models.dto.facility.FacilityDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.facility.Facility;
import com.projeto_fiap.monitoramento_esg.utils.ObjectIdUtil;
import org.springframework.stereotype.Component;

@Component
public class FacilityMapper {

    public FacilityDTO convertFacilityToFacilityDTO(Facility entity) {
        return FacilityDTO
                .builder()
                .id(ObjectIdUtil.toString(entity.getId()))
                .name(entity.getName())
                .address(entity.getAddress())
                .location(entity.getLocation())
                .esgGoals(entity.getEsgGoals())
                .certifications(entity.getCertifications())
                .contacts(entity.getContacts())
                .build();
    }

    public Facility convertFacilityDTOToFacility(FacilityDTO dto) {
        return Facility
                .builder()
                .id(ObjectIdUtil.parseOrNull(dto.getId()))
                .name(dto.getName())
                .address(dto.getAddress())
                .location(dto.getLocation())
                .esgGoals(dto.getEsgGoals())
                .certifications(dto.getCertifications())
                .contacts(dto.getContacts())
                .build();
    }
}
