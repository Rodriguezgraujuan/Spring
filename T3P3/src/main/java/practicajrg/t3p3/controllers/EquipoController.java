package practicajrg.t3p3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practicajrg.t3p3.entities.Equipo;
import practicajrg.t3p3.services.EquipoService;

@Controller
@RequestMapping("/equipo")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("equipos", equipoService.findAll());
        return "equipo/list";
    }

    @GetMapping("/create")
    public String createAuthor(Model model) {
        model.addAttribute("equipo", new Equipo());
        return "equipo/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute Equipo equipo) {
        equipoService.save(equipo);
        return "redirect:/equipo";
    }
}
