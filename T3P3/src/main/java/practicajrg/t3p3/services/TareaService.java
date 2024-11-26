package practicajrg.t3p3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practicajrg.t3p3.repositories.TareaRepository;
import practicajrg.t3p3.repositories.TrabajadorRepository;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private TrabajadorRepository trabajadorRepository;


}
