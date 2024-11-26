package practicajrg.t3p3.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import practicajrg.t3p3.services.EquipoService;
import practicajrg.t3p3.services.TareaService;
import practicajrg.t3p3.services.TrabajadorService;

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
}
