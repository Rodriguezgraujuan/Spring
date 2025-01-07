package practicajrg.t4_p1.Controlador;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import practicajrg.t4_p1.Entidades.Name;

@Controller
public class NameController {
    @GetMapping("/name")
    public String name() {
        return "name";
    }

    @PostMapping("/name")
    public String name(HttpSession session, String name) {
        session.setAttribute("name", name);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(HttpSession session, Model model) {
        Name name = new Name();
        name.setName((String) session.getAttribute("name"));
        if (name.getName() == null) {
            return "redirect:/name";
        }
        model.addAttribute("name", session.getAttribute("name"));
        return "login";
    }
}
