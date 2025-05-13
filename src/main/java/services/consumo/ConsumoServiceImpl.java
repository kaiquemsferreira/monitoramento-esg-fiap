package services.consumo;

import lombok.RequiredArgsConstructor;
import models.dto.consumo.ConsumoDTO;
import models.entity.consumo.Consumo;
import models.mapper.ConsumoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.consumo.ConsumoRepository;
import services.consumo.alerta.AlertaConsumoService;

@Service
@RequiredArgsConstructor
public class ConsumoServiceImpl implements ConsumoService {
    private final AlertaConsumoService alertaConsumoService;
    private final ConsumoRepository consumoRepository;
    private final ConsumoMapper consumoMapper;

    @Override
    public ConsumoDTO registrarConsumo(ConsumoDTO dto) {
        Consumo entity = this.consumoMapper.toEntity(dto);
        if (entity.getDataHora() == null) {
            entity.setDataHora(java.time.LocalDateTime.now());
        }

        Consumo consumo = this.consumoRepository.save(entity);
        this.alertaConsumoService.verificarERegistrarAlertas(consumo);

        return this.consumoMapper.toDTO(consumo);
    }

    @Override
    public Page<ConsumoDTO> listarConsumos(Pageable pageable) {
        return this.consumoRepository.findAll(pageable)
                .map(this.consumoMapper::toDTO);
    }

    @Override
    public Page<ConsumoDTO> listarHistoricoPorSensor(Long sensorId, Pageable pageable) {
        return this.consumoRepository.findBySensorId(sensorId, pageable)
                .map(this.consumoMapper::toDTO);
    }
}
