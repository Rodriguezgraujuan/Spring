package practicajrg.t3p3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="edad", nullable = false)
    private int edad;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;

    @ManyToMany
    @JoinTable(
            name = "Trabajador_Tarea",  // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "trabajador_id"),  // Columna que hace referencia al Trabajador
            inverseJoinColumns = @JoinColumn(name = "tarea_id")  // Columna que hace referencia a la Tarea
    )
    private Set<Tarea> tareas = new HashSet<>();
}
