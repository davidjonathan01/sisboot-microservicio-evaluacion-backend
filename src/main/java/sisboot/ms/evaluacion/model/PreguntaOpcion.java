package sisboot.ms.evaluacion.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pregunta_opcion")

public class PreguntaOpcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opcion")
    private Long idOpcion;

    @ManyToOne
    @JoinColumn(name = "id_test", nullable = false)
    private Test test;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "puntaje")
    private int puntaje;

    public Long getIdOpcion() {
        return this.idOpcion;
    }

    public Test getTest() {
        return this.test;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntaje() {
        return this.puntaje;
    }

    public void setIdOpcion(Long idOpcion) {
        this.idOpcion = idOpcion;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
