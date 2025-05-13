package services.sensores;

import models.dto.sensores.SensoresDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SensoresService {
    SensoresDTO criarSensor(SensoresDTO dto);
    SensoresDTO buscarPorId(Long id);
    Page<SensoresDTO> listarTodos(Pageable pageable);
    SensoresDTO atualizarSensor(Long id, SensoresDTO dto);
    void deletarSensor(Long id);
}
