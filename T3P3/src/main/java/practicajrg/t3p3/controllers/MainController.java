package practicajrg.t3p3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import practicajrg.t3p3.entities.Tarea;
import practicajrg.t3p3.entities.Trabajador;
import practicajrg.t3p3.services.EquipoService;
import practicajrg.t3p3.services.TareaService;
import practicajrg.t3p3.services.TrabajadorService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
    public String cuadroMando(Model model){
        model.addAttribute("trabajador", new Trabajador());
        model.addAttribute("trabajadores", trabajadorService.findAll());
        List<Tarea> listaTareasOrdenada = new java.util.ArrayList<>(tareaService.findAll().stream().filter(p -> p.getStatus().equals(Tarea.Status.Abierta)).toList());
        listaTareasOrdenada.sort(Comparator.comparing(Tarea::getStartDate));
        model.addAttribute("tareasAbiertas", listaTareasOrdenada);
        model.addAttribute("tareasBug", tareaService.findAll().stream().filter(p->p.getType().equals(Tarea.Type.Bug)).toList());
        model.addAttribute("tareasMejora", tareaService.findAll().stream().filter(p->p.getType().equals(Tarea.Type.Mejora)).toList());
        model.addAttribute("tareasRefactorizacion", tareaService.findAll().stream().filter(p->p.getType().equals(Tarea.Type.Refactorizacion)).toList());

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
