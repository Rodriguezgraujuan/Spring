package practicajrg.t4_p1.Controlador;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import practicajrg.t4_p1.Entidades.Counter;

@Controller
public class CounterController {

    @GetMapping("/")
    public String handleRequest(HttpSession session, Model model) {
        Counter counter = (Counter)
                session.getAttribute("counter");
        if (counter == null) {
            counter = new Counter();
        }
        counter.increment();
        session.setAttribute("counter", counter);
        model.addAttribute("count", counter.getCount());
        return "counter";
    }
}
