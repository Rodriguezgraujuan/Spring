package practicajrg.t4_p3.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ErrorAdvisor {

    @ExceptionHandler(ResponseStatusException.class)
    public String handleResponseStatusException(ResponseStatusException ex, Model model) {
        if (ex.getStatusCode() == HttpStatus.BAD_REQUEST) {
            model.addAttribute("message", ex.getReason());
            return "error/400"; // Redirige a la vista de error 400
        } else if (ex.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            model.addAttribute("message", ex.getReason());
            return "error/401"; // Redirige a la vista de error 401
        }
        // Manejar otros códigos de error si es necesario
        return "error/generalError";
    }
}
