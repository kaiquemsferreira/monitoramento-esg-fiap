package controllers.consumo.alerta;

import lombok.RequiredArgsConstructor;
import models.dto.consumo.AlertaConsumoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.consumo.alerta.AlertaConsumoService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/alertas")
public class AlertaController {
    private final AlertaConsumoService alertaConsumoService;

    @GetMapping
    public ResponseEntity<Page<AlertaConsumoDTO>> buscarAlertarPorPagina(
            @PageableDefault(sort = "dataHora", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(this.alertaConsumoService.listarAlertas(pageable));
    }
}
