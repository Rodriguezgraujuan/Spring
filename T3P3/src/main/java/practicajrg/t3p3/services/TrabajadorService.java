package practicajrg.t3p3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practicajrg.t3p3.entities.Trabajador;
import practicajrg.t3p3.repositories.EquipoRepository;
import practicajrg.t3p3.repositories.TareaRepository;
import practicajrg.t3p3.repositories.TrabajadorRepository;

import java.util.List;

@Service
public class TrabajadorService {
    @Autowired
    private TrabajadorRepository trabajadorRepository;
    @Autowired
    private EquipoRepository equipoRepository;
    @Autowired
    private TareaRepository tareaRepository;

    public List<Trabajador> findAll() {
        return trabajadorRepository.findAll();
    }

    public Trabajador save(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador findById(long id) {
        return trabajadorRepository.findById(id).orElse(null);
    }
}
