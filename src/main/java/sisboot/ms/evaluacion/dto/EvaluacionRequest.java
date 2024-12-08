package sisboot.ms.evaluacion.dto;

import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Setter
public class EvaluacionRequest {
    private Long idPaciente;
    private Long idTest;
    private List<Integer> respuestas;

    public Long getIdPaciente() {
        return this.idPaciente;
    }

    public Long getIdTest() {
        return this.idTest;
    }

    public List<Integer> getRespuestas() {
        return this.respuestas;
    }
}
