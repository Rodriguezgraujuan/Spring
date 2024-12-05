package practicajrg.t3p3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import practicajrg.t3p3.entities.Equipo;
import practicajrg.t3p3.entities.Tarea;
import practicajrg.t3p3.services.TareaService;
import practicajrg.t3p3.services.TrabajadorService;

import java.util.HashSet;

@Controller
@RequestMapping("/tarea")
public class TareaController {
    private final TareaService tareaService;
    private final TrabajadorService trabajadorService;

    public TareaController(TareaService tareaService, TrabajadorService trabajadorService) {
        this.tareaService = tareaService;
        this.trabajadorService = trabajadorService;
    }

    @GetMapping
    public String listaTareas(Model model) {
        model.addAttribute("tareas", tareaService.findAll());
        return "tarea/list";
    }

    @GetMapping("/create")
    public String createTarea(Model model) {
        Tarea tarea = new Tarea();
        model.addAttribute("tarea", tarea);
        model.addAttribute("trabajadores", trabajadorService.findAll());
        model.addAttribute("tipos", Tarea.Type.values());
        model.addAttribute("estados", Tarea.Status.values());
        return "tarea/create";
    }

    @PostMapping("/create")
    public String createTarea(@ModelAttribute Tarea tarea, BindingResult result) {
        if (result.hasErrors()) {
            return "tarea/create";
        }
        tareaService.save(tarea);
        return "redirect:/tarea";
    }

    @GetMapping("/modificar/{id}")
    public String modificarTarea(@PathVariable long id, Model model) {
        Tarea tarea = tareaService.findById(id);
        tarea.setTrabajadores(new HashSet<>());
        model.addAttribute("tarea", tarea);
        model.addAttribute("trabajadores", trabajadorService.findAll());
        model.addAttribute("tipos", Tarea.Type.values());
        model.addAttribute("estados", Tarea.Status.values());
        return "tarea/update";
    }

    @PostMapping("/modificar")
    public String modificarTarea(@ModelAttribute Tarea tarea, BindingResult result) {
        if (result.hasErrors()) {
            return "tarea/update";
        }
        tareaService.save(tarea);
        return "redirect:/tarea";
    }

    @GetMapping("/{id}")
    public String tareaDetallada(Model model, @PathVariable long id){
        model.addAttribute("tarea", tareaService.findById(id));
        return "tarea/taD";
    }
}
