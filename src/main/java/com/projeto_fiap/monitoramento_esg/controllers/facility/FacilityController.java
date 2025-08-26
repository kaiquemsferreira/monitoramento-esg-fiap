package com.projeto_fiap.monitoramento_esg.controllers.facility;

import com.projeto_fiap.monitoramento_esg.models.dto.facility.FacilityDTO;
import com.projeto_fiap.monitoramento_esg.services.facility.FacilityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/facilities")
public class FacilityController {
    private final FacilityService facilityService;

    @GetMapping
    public Page<FacilityDTO> list(@PageableDefault(size = 20) Pageable pageable) {
        return this.facilityService.list(pageable);
    }

    @GetMapping("/{id}")
    public FacilityDTO get(@PathVariable String id) {
        return this.facilityService.get(id);
    }

    @PostMapping
    public FacilityDTO create(@RequestBody FacilityDTO input) {
        return this.facilityService.create(input);
    }

    @PutMapping("/{id}")
    public FacilityDTO update(@PathVariable String id, @RequestBody @Valid FacilityDTO input) {
        return this.facilityService.update(id, input);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.facilityService.delete(id);
    }
}
