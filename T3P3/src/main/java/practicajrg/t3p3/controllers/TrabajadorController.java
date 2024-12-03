package practicajrg.t3p3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practicajrg.t3p3.entities.Equipo;
import practicajrg.t3p3.entities.Tarea;
import practicajrg.t3p3.entities.Trabajador;
import practicajrg.t3p3.services.EquipoService;
import practicajrg.t3p3.services.TareaService;
import practicajrg.t3p3.services.TrabajadorService;

import java.time.LocalDate;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {

    private final TrabajadorService trabajadorService;
    private final EquipoService equipoService;
    private final TareaService tareaService;

    public TrabajadorController(EquipoService equipoService, TareaService tareaService,TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
        this.equipoService = equipoService;
        this.tareaService = tareaService;

    }

    @GetMapping
    public String listaTrabajadores(Model model) {
        model.addAttribute("trabajadores", trabajadorService.findAll());
        return "trabajador/list";
    }

    @GetMapping("/create")
    public String createTrabajador(Model model) {
        model.addAttribute("trabajador", new Trabajador());
        model.addAttribute("equipos", equipoService.findAll());
        model.addAttribute("tareas", tareaService.findAll());
        return "trabajador/create";
    }

    @PostMapping("/create")
    public String createTrabajador(@ModelAttribute Trabajador trabajador) {
        trabajadorService.save(trabajador);
        return "redirect:/trabajador/list";
    }
}
