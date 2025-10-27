package com.projeto_fiap.monitoramento_esg.services.alert;

import com.projeto_fiap.monitoramento_esg.exceptions.AlertNotFoundException;
import com.projeto_fiap.monitoramento_esg.mappers.alert.AlertMapper;
import com.projeto_fiap.monitoramento_esg.models.dto.alert.AlertDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.alert.Alert;
import com.projeto_fiap.monitoramento_esg.repository.alert.AlertRepository;
import com.projeto_fiap.monitoramento_esg.utils.ObjectIdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AlertService {
    private final AlertRepository alertRepository;
    private final AlertMapper alertMapper;

    public Page<AlertDTO> list(String sensorId, String status, Pageable pageable) {
        boolean hasSensor = sensorId != null && !sensorId.isBlank();
        boolean hasStatus = status != null && !status.isBlank();

        if (hasSensor) {
            var sid = ObjectIdUtil.parseOrNull(sensorId);
            if (sid == null) {
                return Page.empty(pageable);
            }
            if (hasStatus) return this.alertRepository.findBySensorIdAndStatus(sid, status, pageable).map(this.alertMapper::toDto);
            return this.alertRepository.findBySensorId(sid, pageable).map(this.alertMapper::toDto);
        }
        if (hasStatus) return this.alertRepository.findByStatus(status, pageable).map(this.alertMapper::toDto);
        return this.alertRepository.findAll(pageable).map(this.alertMapper::toDto);
    }

    public AlertDTO get(String id) {
        var oid = ObjectIdUtil.parseOrNull(id);
        if (oid == null) throw new AlertNotFoundException("Alerta não encontrado: " + id);
        return this.alertRepository.findById(oid)
                .map(this.alertMapper::toDto)
                .orElseThrow(() -> new AlertNotFoundException("Alerta não encontrado: " + id));
    }

    public AlertDTO create(AlertDTO input) {
        input.setId(null);
        if (input.getType() == null) input.setType("threshold");
        if (input.getStatus() == null || input.getStatus().isBlank()) input.setStatus("open");
        if (input.getCreatedAt() == null) input.setCreatedAt(new Date());

        Alert saved = this.alertRepository.save(this.alertMapper.toEntity(input));
        return this.alertMapper.toDto(saved);
    }

    public AlertDTO update(String id, AlertDTO input) {
        var oid = ObjectIdUtil.parseOrNull(id);

        var existing = this.alertRepository.findById(oid)
                .orElseThrow(() -> new AlertNotFoundException("Alerta não encontrado: " + id));

        input.setId(id);
        if (input.getCreatedAt() == null) input.setCreatedAt(existing.getCreatedAt());
        var saved = this.alertRepository.save(this.alertMapper.toEntity(input));
        return this.alertMapper.toDto(saved);
    }

    public AlertDTO resolve(String id) {
        var dto = get(id);
        dto.setStatus("resolved");
        dto.setResolvedAt(new Date());
        var saved = this.alertRepository.save(this.alertMapper.toEntity(dto));
        return this.alertMapper.toDto(saved);
    }

    public void delete(String id) {
        var oid = ObjectIdUtil.parseOrNull(id);
        if (oid == null) throw new AlertNotFoundException("Alerta não encontrado: " + id);
        if (!this.alertRepository.existsById(oid)) throw new AlertNotFoundException("Alerta não encontrado: " + id);
        this.alertRepository.deleteById(oid);
    }
}
