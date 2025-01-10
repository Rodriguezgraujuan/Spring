package practicajrg.t4_p3.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
