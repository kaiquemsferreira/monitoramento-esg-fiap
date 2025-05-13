package repository.consumo;

import models.entity.consumo.AlertaConsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaConsumoRepository extends JpaRepository<AlertaConsumo, Long> {
}

