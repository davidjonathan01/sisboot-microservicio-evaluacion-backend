package sisboot.ms.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sisboot.ms.evaluacion.model.Rango;

import java.util.List;

public interface RangoRepository extends JpaRepository<Rango, Long> {
    List<Rango> findByTest_IdTest(Long idTest);
}
