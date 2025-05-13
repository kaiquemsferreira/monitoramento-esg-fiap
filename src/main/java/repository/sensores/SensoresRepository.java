package repository.sensores;

import models.entity.sensores.Sensores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensoresRepository extends JpaRepository<Sensores, Long> {
}
