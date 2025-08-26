package com.projeto_fiap.monitoramento_esg.controllers.compliance;

import com.projeto_fiap.monitoramento_esg.models.dto.compliance.ComplianceLogDTO;
import com.projeto_fiap.monitoramento_esg.services.compliance.ComplianceLogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/compliance-log")
public class ComplianceLogController {
    private final ComplianceLogService complianceLogService;

    @GetMapping
    public Page<ComplianceLogDTO> list(@RequestParam(required = false) String action,
                                       @RequestParam(required = false) String entity,
                                       @RequestParam(required = false) String entityId,
                                       @PageableDefault(size = 20, sort = "timestamp") Pageable pageable) {
        return this.complianceLogService.list(action, entity, entityId, pageable);
    }


    @GetMapping("/{id}")
    public ComplianceLogDTO get(@PathVariable String id) {
        return this.complianceLogService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComplianceLogDTO create(@Valid @RequestBody ComplianceLogDTO body) {
        return this.complianceLogService.create(body);
    }

    @PutMapping("/{id}")
    public ComplianceLogDTO update(@PathVariable String id, @Valid @RequestBody ComplianceLogDTO body) {
        return this.complianceLogService.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        this.complianceLogService.delete(id);
    }
}
