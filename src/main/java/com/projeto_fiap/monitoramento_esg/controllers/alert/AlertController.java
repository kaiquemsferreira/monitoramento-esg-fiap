package com.projeto_fiap.monitoramento_esg.controllers.alert;

import com.projeto_fiap.monitoramento_esg.models.dto.alert.AlertDTO;
import com.projeto_fiap.monitoramento_esg.services.alert.AlertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/AlertDTO")
public class AlertController {
    private final AlertService alertService;


    @GetMapping
    public Page<AlertDTO> list(@RequestParam(required = false) String sensorId,
                               @RequestParam(required = false) String status,
                               @PageableDefault(size = 20, sort = "createdAt") Pageable pageable) {
        return this.alertService.list(sensorId, status, pageable);
    }

    @GetMapping("/{id}")
    public AlertDTO get(@PathVariable String id) {
        return this.alertService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlertDTO create(@Valid @RequestBody AlertDTO body) {
        return this.alertService.create(body);
    }

    @PutMapping("/{id}")
    public AlertDTO update(@PathVariable String id, @Valid @RequestBody AlertDTO body) {
        return this.alertService.update(id, body);
    }

    @PostMapping("/{id}/resolve")
    public AlertDTO resolve(@PathVariable String id) {
        return this.alertService.resolve(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        this.alertService.delete(id);
    }
}
