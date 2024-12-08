package sisboot.ms.evaluacion.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "pregunta")
@Data
public class Pregunta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private Long idPregunta;

    @ManyToOne
    @JoinColumn(name = "id_test", nullable = false)
    private Test test;

    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false)
    private Area area;

    @Column(name = "interrogante")
    private String interrogante;

    public Long getIdPregunta() {
        return this.idPregunta;
    }

    public Test getTest() {
        return this.test;
    }

    public Area getArea() {
        return this.area;
    }

    public String getInterrogante() {
        return this.interrogante;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setInterrogante(String interrogante) {
        this.interrogante = interrogante;
    }
}
