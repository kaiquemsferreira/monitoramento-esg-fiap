package controllers.sensores;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.dto.sensores.SensoresDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.sensores.SensoresService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sensores")
public class SensoresController {
    private final SensoresService sensoresService;

    @PostMapping
    public ResponseEntity<SensoresDTO> criarSensor(@RequestBody @Valid SensoresDTO dto) {
        SensoresDTO sensor = this.sensoresService.criarSensor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(sensor);
    }

    @GetMapping
    public ResponseEntity<Page<SensoresDTO>> listarTodosSensores(
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<SensoresDTO> sensores = this.sensoresService.listarTodos(pageable);
        return ResponseEntity.ok(sensores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensoresDTO> buscarSensorPorId(@PathVariable Long id) {
        SensoresDTO sensor = this.sensoresService.buscarPorId(id);
        return ResponseEntity.ok(sensor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensoresDTO> atualizarSensor(@PathVariable Long id, @RequestBody @Valid SensoresDTO dto) {
        SensoresDTO sensorAtualizado = this.sensoresService.atualizarSensor(id, dto);
        return ResponseEntity.ok(sensorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSensor(@PathVariable Long id) {
        this.sensoresService.deletarSensor(id);
        return ResponseEntity.noContent().build();
    }
}
