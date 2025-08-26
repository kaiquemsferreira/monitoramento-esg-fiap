package com.projeto_fiap.monitoramento_esg.controllers.sensor;

import com.projeto_fiap.monitoramento_esg.models.dto.sensor.SensorDTO;
import com.projeto_fiap.monitoramento_esg.services.sensor.SensorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sensor")
public class SensorController {
    private final SensorService sensorService;

    @GetMapping
    public Page<SensorDTO> list(@RequestParam(required = false) String facilityId,
                                @PageableDefault(size = 20, sort = "name") Pageable pageable) {
        return this.sensorService.list(facilityId, pageable);
    }

    @GetMapping("/{id}")
    public SensorDTO get(@PathVariable String id) {
        return this.sensorService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SensorDTO create(@Valid @RequestBody SensorDTO body) {
        return this.sensorService.create(body);
    }

    @PutMapping("/{id}")
    public SensorDTO update(@PathVariable String id, @Valid @RequestBody SensorDTO body) {
        return this.sensorService.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        this.sensorService.delete(id);
    }
}
