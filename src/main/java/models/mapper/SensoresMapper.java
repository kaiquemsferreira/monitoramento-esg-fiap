package models.mapper;

import lombok.RequiredArgsConstructor;
import models.dto.sensores.SensoresDTO;
import models.entity.sensores.Sensores;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SensoresMapper {

    public SensoresDTO toDTO(Sensores entity) {
        return SensoresDTO.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .localizacao(entity.getLocalizacao())
                .build();
    }

    public Sensores toEntity(SensoresDTO input) {
        return Sensores
                .builder()
                .id(input.getId())
                .nome(input.getNome())
                .localizacao(input.getLocalizacao())
                .build();
    }
}
