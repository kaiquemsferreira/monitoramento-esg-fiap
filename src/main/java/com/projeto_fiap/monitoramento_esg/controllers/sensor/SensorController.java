package com.projeto_fiap.monitoramento_esg.controllers.sensor;

import com.projeto_fiap.monitoramento_esg.models.dto.sensor.SensorDTO;
import com.projeto_fiap.monitoramento_esg.services.sensor.SensorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        value = "/api/sensor",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class SensorController {
    private final SensorService sensorService;

    @GetMapping
    public Page<SensorDTO> list(@RequestParam(required = false) String facilityId,
                                @PageableDefault(size = 20, sort = "name") Pageable pageable) {
        return this.sensorService.list(facilityId, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorDTO> get(@PathVariable String id) {
        return ResponseEntity.ok(this.sensorService.get(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SensorDTO> create(@Valid @RequestBody SensorDTO req) {
        SensorDTO salvo = this.sensorService.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorDTO> update(@PathVariable String id, @Valid @RequestBody SensorDTO req) {
        SensorDTO sensor = this.sensorService.update(id, req);
        return ResponseEntity.status(HttpStatus.OK).body(sensor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.sensorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
