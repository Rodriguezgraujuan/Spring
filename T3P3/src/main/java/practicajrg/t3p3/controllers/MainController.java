package practicajrg.t3p3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import practicajrg.t3p3.entities.Tarea;
import practicajrg.t3p3.services.EquipoService;
import practicajrg.t3p3.services.TareaService;
import practicajrg.t3p3.services.TrabajadorService;

import java.time.LocalDate;

@Controller
public class MainController {
    private final TrabajadorService trabajadorService;
    private final EquipoService equipoService;
    private final TareaService tareaService;

    public MainController(EquipoService equipoService, TareaService tareaService,TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
        this.equipoService = equipoService;
        this.tareaService = tareaService;

    }

    @GetMapping("/")
    public String listaEquipos(Model model) {
        return "index";
    }

    @GetMapping("/mando")
    public String cuadroMando(){
        return "cuadroDeMando";
    }

    @GetMapping("/retrasadas")
    public String tareasRetrasadas(Model model){
       model.addAttribute("tareas", tareaService.findAll().stream().filter(p->p.getEndDate().isBefore(LocalDate.now())
                && p.getStatus()==Tarea.Status.Abierta
                || p.getStatus()==Tarea.Status.Progreso).toList());
        return "retrasadas";
    }
}
