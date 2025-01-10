package practicajrg.t4_p3.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.*;


@Controller
public class ErrorManagementController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/prueba")
    public String prueba() {
        throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
    }

    @GetMapping("/error403")
    public String error1() {
        throw new ResponseStatusException(FORBIDDEN,"Forbidden");
    }
    @GetMapping("/error401")
    public String error2() {
        throw new ResponseStatusException(UNAUTHORIZED,"Unauthorized");
    }
    @GetMapping("/error500")
    public String error3() {
        throw new ResponseStatusException(INTERNAL_SERVER_ERROR,"Internal Server Error");
    }
    @GetMapping("/error400")
    public String error4() {
        throw new ResponseStatusException(BAD_REQUEST,"Bad Request Type");
    }

    @GetMapping("/suma/{num1}/{num2}")
    public String suma(@PathVariable int num1, @PathVariable int num2, Model model) {
        model.addAttribute("suma", num1 + num2);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        return "calculator/suma";
    }

    @GetMapping("/division/{num1}/{num2}")
    public String division(@PathVariable int num1, @PathVariable int num2, Model model) {
        if (num2==0){
            throw new ResponseStatusException(BAD_REQUEST,"No se puede dividir por 0");
        }

        model.addAttribute("divi", num1 / num2);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        return "calculator/division";
    }

    @GetMapping("/raiz/{num1}")
    public String raiz(@PathVariable int num1, Model model) {
        if (true) {
            throw new ResponseStatusException(UNAUTHORIZED, "No tienes permisos");
        }
        model.addAttribute("raiz", Math.sqrt(num1));
        model.addAttribute("num1",num1);
        return "calculator/raiz";
    }

    @GetMapping("/factorial/{num1}")
    public String factorial(@PathVariable int num1, Model model) {
        if (num1>100){
            throw new ResponseStatusException(BAD_REQUEST,"Operacion demasiado compleja");
        } else if (num1<0) {
            throw new ResponseStatusException(BAD_REQUEST,"Numeros negativos no son validos");
        }
        model.addAttribute("num1", num1);
        model.addAttribute("factorial", fact(num1));
        return "calculator/factorial";
    }

    public int fact(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
