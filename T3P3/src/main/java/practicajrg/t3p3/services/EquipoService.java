package practicajrg.t3p3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practicajrg.t3p3.entities.Equipo;
import practicajrg.t3p3.repositories.EquipoRepository;
import practicajrg.t3p3.repositories.TrabajadorRepository;

import java.util.List;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo findById(long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    public Equipo update(Equipo equipo) {
        Equipo equipoExistente = equipoRepository.findById((long) equipo.getId()).orElse(null);
        assert equipoExistente != null;
        equipoExistente.setName(equipo.getName());
        return equipoRepository.save(equipoExistente);
    }
}
