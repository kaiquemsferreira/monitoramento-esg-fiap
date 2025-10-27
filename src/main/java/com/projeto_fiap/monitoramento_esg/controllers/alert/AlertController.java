package com.projeto_fiap.monitoramento_esg.controllers.alert;

import com.projeto_fiap.monitoramento_esg.models.dto.alert.AlertDTO;
import com.projeto_fiap.monitoramento_esg.services.alert.AlertService;
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
        value = "/api/alert",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class AlertController {
    private final AlertService alertService;


    @GetMapping
    public Page<AlertDTO> list(@RequestParam(required = false) String sensorId,
                               @RequestParam(required = false) String status,
                               @PageableDefault(size = 20, sort = "createdAt") Pageable pageable) {
        return this.alertService.list(sensorId, status, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertDTO> get(@PathVariable String id) {
        return ResponseEntity.ok(this.alertService.get(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AlertDTO> create(@Valid @RequestBody AlertDTO req) {
        AlertDTO salvo = this.alertService.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertDTO> update(@PathVariable String id, @Valid @RequestBody AlertDTO req) {
        AlertDTO alert = this.alertService.update(id, req);
        return ResponseEntity.status(HttpStatus.OK).body(alert);
    }

    @PostMapping("/{id}/resolve")
    public ResponseEntity<AlertDTO> resolve(@PathVariable String id) {
        return ResponseEntity.ok(this.alertService.resolve(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.alertService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
