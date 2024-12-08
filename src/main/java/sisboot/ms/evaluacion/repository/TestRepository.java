package sisboot.ms.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sisboot.ms.evaluacion.model.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
}
