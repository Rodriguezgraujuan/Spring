package practicajrg.t3p3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practicajrg.t3p3.entities.Equipo;
import practicajrg.t3p3.entities.Tarea;
import practicajrg.t3p3.services.TareaService;

@Controller
@RequestMapping("/tarea")
public class TareaController {
    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping
    public String listaEquipos(Model model) {
        model.addAttribute("tareas", tareaService.findAll());
        return "tarea/list";
    }

    @GetMapping("/create")
    public String createTarea(Model model) {
        model.addAttribute("tarea", new Tarea());
        model.addAttribute("typeValues", Tarea.Type.values());
        model.addAttribute("statusValues", Tarea.Status.values());
        return "tarea/create";
    }

    @PostMapping("/create")
    public String createTarea(@ModelAttribute Tarea tarea) {
        tareaService.save(tarea);
        return "redirect:/tarea";
    }
}
