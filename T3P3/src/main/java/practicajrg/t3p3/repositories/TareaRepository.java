package practicajrg.t3p3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import practicajrg.t3p3.entities.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
