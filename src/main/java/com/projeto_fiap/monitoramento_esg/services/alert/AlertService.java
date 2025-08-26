package com.projeto_fiap.monitoramento_esg.services.alert;

import com.projeto_fiap.monitoramento_esg.exceptions.AlertNotFoundException;
import com.projeto_fiap.monitoramento_esg.mappers.alert.AlertMapper;
import com.projeto_fiap.monitoramento_esg.models.dto.alert.AlertDTO;
import com.projeto_fiap.monitoramento_esg.models.entity.alert.Alert;
import com.projeto_fiap.monitoramento_esg.repository.alert.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.projeto_fiap.monitoramento_esg.constants.MensagensConstantes.ALERT_NOT_FOUND_WITH_ID;

@Service
@RequiredArgsConstructor
public class AlertService {
    private final AlertRepository alertRepository;
    private final AlertMapper alertMapper;

    public Page<AlertDTO> list(String sensorId, String status, Pageable pageable) {
        boolean hasSensor = sensorId != null && !sensorId.isBlank();
        boolean hasStatus = status != null && !status.isBlank();

        if (hasSensor && hasStatus) return this.alertRepository.findBySensorIdAndStatus(sensorId, status, pageable)
                .map(this.alertMapper::convertAlertToAlertDTO);
        if (hasSensor) return this.alertRepository.findBySensorId(sensorId, pageable)
                .map(this.alertMapper::convertAlertToAlertDTO);
        if (hasStatus) return this.alertRepository.findByStatus(status, pageable)
                .map(this.alertMapper::convertAlertToAlertDTO);
        return this.alertRepository.findAll(pageable)
                .map(this.alertMapper::convertAlertToAlertDTO);
    }


    public AlertDTO get(String id) {
        return this.alertRepository.findById(id)
                .map(this.alertMapper::convertAlertToAlertDTO)
                .orElseThrow(() -> new AlertNotFoundException(ALERT_NOT_FOUND_WITH_ID + id));
    }

    public AlertDTO create(AlertDTO input) {
        Alert alert = this.alertMapper.convertAlertDTOToAlert(input);
        Alert savedAlert = this.alertRepository.save(alert);
        return this.alertMapper.convertAlertToAlertDTO(savedAlert);
    }

    public AlertDTO update(String id, AlertDTO input) {
        input.setId(id);
        Alert alert = this.alertMapper.convertAlertDTOToAlert(input);
        Alert savedAlert = this.alertRepository.save(alert);
        return this.alertMapper.convertAlertToAlertDTO(savedAlert);
    }

    public AlertDTO resolve(String id) {
        AlertDTO a = this.get(id);
        a.setStatus("resolved");
        a.setResolvedAt(java.time.Instant.now());
        Alert alert = this.alertMapper.convertAlertDTOToAlert(a);
        Alert savedAlert = this.alertRepository.save(alert);
        return this.alertMapper.convertAlertToAlertDTO(savedAlert);
    }

    public void delete(String id) {
        this.alertRepository.deleteById(id);
    }
}
