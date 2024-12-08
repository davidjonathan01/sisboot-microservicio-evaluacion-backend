package sisboot.ms.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sisboot.ms.evaluacion.model.Pregunta;

import java.util.List;

public interface PreguntaRepository extends JpaRepository <Pregunta, Long> {

    List<Pregunta> findByTest_IdTest(Long idTest);
}
