package sisboot.ms.evaluacion.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test")
    private Long idTest;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "n_preguntas")
    private int nPreguntas;

    public Long getIdTest() {
        return this.idTest;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getNPreguntas() {
        return this.nPreguntas;
    }

    public void setIdTest(Long idTest) {
        this.idTest = idTest;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNPreguntas(int nPreguntas) {
        this.nPreguntas = nPreguntas;
    }
}
