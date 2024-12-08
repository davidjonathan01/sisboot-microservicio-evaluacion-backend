package sisboot.ms.evaluacion.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "rango")

public class Rango {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rango")
    private Long idRango;

    @ManyToOne
    @JoinColumn(name = "id_test", nullable = false)
    private Test test;

    @Column(name = "puntaje_min")
    private int puntajeMin;

    @Column(name = "puntaje_max")
    private int puntajeMax;

    @Column(name = "nombre")
    private String nombre;

    public Long getIdRango() {
        return this.idRango;
    }

    public Test getTest() {
        return this.test;
    }

    public int getPuntajeMin() {
        return this.puntajeMin;
    }

    public int getPuntajeMax() {
        return this.puntajeMax;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setIdRango(Long idRango) {
        this.idRango = idRango;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public void setPuntajeMin(int puntajeMin) {
        this.puntajeMin = puntajeMin;
    }

    public void setPuntajeMax(int puntajeMax) {
        this.puntajeMax = puntajeMax;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
