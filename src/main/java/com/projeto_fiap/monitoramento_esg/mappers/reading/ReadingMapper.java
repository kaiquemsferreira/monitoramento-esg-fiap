package com.projeto_fiap.monitoramento_esg.mappers.reading;

import com.projeto_fiap.monitoramento_esg.models.dto.reading.ReadingDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.reading.Reading;
import org.springframework.stereotype.Component;

@Component
public class ReadingMapper {

    public ReadingDTO convertReadingToReadingDTO(Reading entity) {
        return ReadingDTO
                .builder()
                .id(entity.getId())
                .sensorId(entity.getSensorId())
                .ts(entity.getTs())
                .kwh(entity.getKwh())
                .metadata(entity.getMetadata())
                .temperatureC(entity.getTemperatureC())
                .notes(entity.getNotes())
                .build();
    }

    public Reading convertReadingDTOToReading(ReadingDTO dto) {
        return Reading
                .builder()
                .id(dto.getId())
                .sensorId(dto.getSensorId())
                .ts(dto.getTs())
                .kwh(dto.getKwh())
                .metadata(dto.getMetadata())
                .temperatureC(dto.getTemperatureC())
                .notes(dto.getNotes())
                .build();
    }
}
