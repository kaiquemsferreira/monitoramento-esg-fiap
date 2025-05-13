package controllers.consumo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.dto.consumo.ConsumoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.consumo.ConsumoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consumo")
public class ConsumoController {
    private final ConsumoService consumoService;

    @PostMapping
    public ResponseEntity<ConsumoDTO> registrar(@RequestBody @Valid ConsumoDTO dto) {
        ConsumoDTO consumo = this.consumoService.registrarConsumo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(consumo);
    }

    @GetMapping
    public ResponseEntity<Page<ConsumoDTO>> listarTodos(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(this.consumoService.listarConsumos(pageable));
    }

    @GetMapping("/historico/{sensorId}")
    public ResponseEntity<Page<ConsumoDTO>> historicoPorSensor(
            @PathVariable Long sensorId,
            @PageableDefault(sort = "dataHora", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(this.consumoService.listarHistoricoPorSensor(sensorId, pageable));
    }
}
