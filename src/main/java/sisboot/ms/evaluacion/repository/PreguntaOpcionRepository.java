package sisboot.ms.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sisboot.ms.evaluacion.model.Pregunta;
import sisboot.ms.evaluacion.model.PreguntaOpcion;

import java.util.List;
import java.util.Optional;

public interface PreguntaOpcionRepository extends JpaRepository<PreguntaOpcion, Long> {
    List<PreguntaOpcion> findByTest_IdTest(Long idTest);
}
