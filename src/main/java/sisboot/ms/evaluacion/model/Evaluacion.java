package sisboot.ms.evaluacion.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "evaluacion")

public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluacion")
    private Long idEvaluacion;

    @Column(name = "id_paciente")
    private Long idPaciente;

    @ManyToOne
    @JoinColumn(name = "id_test")
    private Test test;

    @ManyToOne
    @JoinColumn(name = "id_rango", nullable = false)
    private Rango rango;

    @Column(name = "respuestas")
    private String respuestas;

    @Column(name = "puntaje_total")
    private int puntajeTotal;

    @Column(name = "fecha")
    private java.time.LocalDate fecha;

    public Long getIdEvaluacion() {
        return this.idEvaluacion;
    }

    public Long getIdPaciente() {
        return this.idPaciente;
    }

    public Test getTest() {
        return this.test;
    }

    public Rango getRango() {
        return this.rango;
    }

    public String getRespuestas() {
        return this.respuestas;
    }

    public int getPuntajeTotal() {
        return this.puntajeTotal;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setIdEvaluacion(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public void setRespuestas(String respuestas) {
        this.respuestas = respuestas;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
