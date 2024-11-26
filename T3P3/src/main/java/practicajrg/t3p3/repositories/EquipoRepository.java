package practicajrg.t3p3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import practicajrg.t3p3.entities.Equipo;
import practicajrg.t3p3.entities.Trabajador;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
