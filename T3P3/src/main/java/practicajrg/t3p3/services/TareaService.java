package practicajrg.t3p3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practicajrg.t3p3.controllers.TareaController;
import practicajrg.t3p3.entities.Equipo;
import practicajrg.t3p3.entities.Tarea;
import practicajrg.t3p3.repositories.TareaRepository;
import practicajrg.t3p3.repositories.TrabajadorRepository;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private TrabajadorRepository trabajadorRepository;


    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea findById(long id) {
        return tareaRepository.findById(id).orElse(null);
    }
}
