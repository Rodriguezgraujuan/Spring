package practicajrg.t4_p2.Controladores;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class LoginController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/private")
    public String privateZone(Model model) {
        authorization(model);
        return "private";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        authorization(model);
        return "admin";
    }

    private void authorization(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();
        List<String> rolesName = roles.stream().map(GrantedAuthority::getAuthority).map(role -> role.replace("ROLE_","")).toList();
        model.addAttribute("username", username);
        model.addAttribute("roles", rolesName);
    }
}
