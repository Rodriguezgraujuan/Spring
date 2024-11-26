package practicajrg.t3p3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import practicajrg.t3p3.entities.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
}
