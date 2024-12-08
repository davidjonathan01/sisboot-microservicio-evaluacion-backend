package sisboot.ms.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sisboot.ms.evaluacion.model.Evaluacion;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
}
