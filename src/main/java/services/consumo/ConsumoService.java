package services.consumo;

import models.dto.consumo.ConsumoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConsumoService {
    ConsumoDTO registrarConsumo(ConsumoDTO dto);
    Page<ConsumoDTO> listarConsumos(Pageable pageable);
    Page<ConsumoDTO> listarHistoricoPorSensor(Long sensorId, Pageable pageable);
}
