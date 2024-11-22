package practicajrg.t3p3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description", nullable = true)
    private String description;

    @Column(name="startDate", nullable = false)
    private Date startDate;

    @Column(name="endDate", nullable = false)
    private Date endDate;

    @Column(name="type", nullable = false)
    private Type type;

    enum Type{
        Mejora, Bug, Refactorizacion
    }

    @Column(name="status", nullable = false)
    private Status status;

    enum Status{
        Abierta, Progreso, Cerrada
    }

    @ManyToMany(mappedBy = "tareas")
    private Set<Trabajador> trabajadores = new HashSet<>();
}
