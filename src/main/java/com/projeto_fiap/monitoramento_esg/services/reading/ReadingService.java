package com.projeto_fiap.monitoramento_esg.services.reading;

import com.projeto_fiap.monitoramento_esg.exceptions.ReadingNotFoundException;
import com.projeto_fiap.monitoramento_esg.mappers.reading.ReadingMapper;
import com.projeto_fiap.monitoramento_esg.models.dto.reading.ReadingDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.reading.Reading;
import com.projeto_fiap.monitoramento_esg.repository.reading.ReadingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static com.projeto_fiap.monitoramento_esg.constants.MensagensConstantes.FACILITY_NOT_FOUND_WITH_ID;

@Service
@RequiredArgsConstructor
public class ReadingService {
    private final ReadingRepository readingRepository;
    private final ReadingMapper readingMapper;

    public Page<ReadingDTO> list(String sensorId, Instant from, Instant to, Pageable pageable) {
        if (sensorId != null && !sensorId.isBlank()) {
            if (from != null && to != null) {
                return this.readingRepository.findBySensorIdAndTsBetween(sensorId, from, to, pageable)
                        .map(this.readingMapper::toDto);
            }
            return this.readingRepository.findBySensorId(sensorId, pageable)
                    .map(this.readingMapper::toDto);
        }
        return this.readingRepository.findAll(pageable)
                .map(this.readingMapper::toDto);
    }

    public ReadingDTO get(String id) {
        return this.readingRepository.findById(id)
                .map(readingMapper::toDto)
                .orElseThrow(() -> new ReadingNotFoundException(FACILITY_NOT_FOUND_WITH_ID + id));
    }

    public ReadingDTO create(ReadingDTO input) {
        Reading reading = this.readingMapper.toEntity(input);
        Reading savedReading = this.readingRepository.save(reading);
        return this.readingMapper.toDto(savedReading);
    }

    public ReadingDTO update(String id, ReadingDTO input) {
        input.setId(id);
        Reading reading = this.readingMapper.toEntity(input);
        Reading savedReading = this.readingRepository.save(reading);
        return this.readingMapper.toDto(savedReading);
    }

    public void delete(String id) {
        this.readingRepository.deleteById(id);
    }
}
