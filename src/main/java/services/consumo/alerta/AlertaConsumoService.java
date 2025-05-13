package services.consumo.alerta;

import models.dto.consumo.AlertaConsumoDTO;
import models.entity.consumo.Consumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlertaConsumoService {
    Page<AlertaConsumoDTO> listarAlertas(Pageable pageable);
    void verificarERegistrarAlertas(Consumo consumo);
}
