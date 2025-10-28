package com.projeto_fiap.monitoramento_esg.controllers.reading;

import com.projeto_fiap.monitoramento_esg.models.dto.reading.ReadingDTO;
import com.projeto_fiap.monitoramento_esg.services.reading.ReadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reading")
public class ReadingController {
    private final ReadingService readingService;


    @GetMapping
    public Page<ReadingDTO> list(@RequestParam(required = false) String sensorId,
                                 @RequestParam(required = false)
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
                                 @RequestParam(required = false)
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to,
                                 @PageableDefault(size = 20, sort = "ts") Pageable pageable) {
        return this.readingService.list(sensorId, from, to, pageable);
    }

    @GetMapping("/{id}")
    public ReadingDTO get(@PathVariable String id) {
        return this.readingService.get(id);
    }

    @PostMapping
    public ResponseEntity<ReadingDTO> create(@RequestBody ReadingDTO body) {
        return ResponseEntity.ok(this.readingService.create(body));
    }

    @PutMapping("/{id}")
    public ReadingDTO update(@PathVariable String id, @RequestBody ReadingDTO body) {
        return this.readingService.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        this.readingService.delete(id);
    }
}
