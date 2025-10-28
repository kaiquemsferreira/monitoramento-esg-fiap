package com.projeto_fiap.monitoramento_esg.mappers.reading;

import com.projeto_fiap.monitoramento_esg.models.dto.reading.ReadingDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.reading.Reading;
import com.projeto_fiap.monitoramento_esg.utils.ObjectIdUtil;
import org.springframework.stereotype.Component;

@Component
public class ReadingMapper {

    public ReadingDTO toDto(Reading entity) {
        return ReadingDTO
                .builder()
                .id(ObjectIdUtil.toString(entity.getId()))
                .sensorId(ObjectIdUtil.toString(entity.getSensorId()))
                .ts(entity.getTs())
                .kwh(entity.getKwh())
                .metadata(entity.getMetadata())
                .temperatureC(entity.getTemperatureC())
                .notes(entity.getNotes())
                .build();
    }

    public Reading toEntity(ReadingDTO dto) {
        return Reading
                .builder()
                .id(ObjectIdUtil.parseOrNull(dto.getId()))
                .sensorId(ObjectIdUtil.parseOrNull(dto.getSensorId()))
                .ts(dto.getTs())
                .kwh(dto.getKwh())
                .metadata(dto.getMetadata())
                .temperatureC(dto.getTemperatureC())
                .notes(dto.getNotes())
                .build();
    }
}
