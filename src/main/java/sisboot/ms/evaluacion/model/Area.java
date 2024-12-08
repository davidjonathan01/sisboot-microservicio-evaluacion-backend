package sisboot.ms.evaluacion.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Long idArea;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    public Long getIdArea() {
        return this.idArea;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
