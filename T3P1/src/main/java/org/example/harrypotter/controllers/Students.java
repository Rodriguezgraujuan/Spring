package org.example.harrypotter.controllers;

import org.example.harrypotter.entities.Student;
import org.example.harrypotter.repositories.StudentRepository;
import org.example.harrypotter.services.StudentService;
import org.example.harrypotter.services.StudentServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Students {
    private StudentService student = new StudentServiceImplementation(new StudentRepository());

    @GetMapping("/house/{houseStudent}")
    public String houseStudent(@PathVariable String houseStudent, Model model) {
        model.addAttribute("students", student.getStudentsByHouse(houseStudent));
        return "Students-House";
    }

    @GetMapping("/houseStudent")
    public String studentRequestedPram(@RequestParam(value ="name") String name, Model model) {
        model.addAttribute("student", student.getStudentByName(name));
        return "StudentDetalled";
    }

    @GetMapping("/StudentD/{name}")
    public String getHouse(Model model, @PathVariable String name) {
        model.addAttribute("student",student.getStudentByName(name));
        return "StudentDetalled";
    }
}
