package org.example.harrypotter.controllers;

import org.example.harrypotter.entities.House;
import org.example.harrypotter.entities.Student;
import org.example.harrypotter.repositories.HouseRepository;
import org.example.harrypotter.repositories.StudentRepository;
import org.example.harrypotter.services.HouseService;
import org.example.harrypotter.services.HouseServiceImplementation;
import org.example.harrypotter.services.StudentService;
import org.example.harrypotter.services.StudentServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Students {
    private StudentService students = new StudentServiceImplementation(new StudentRepository());
    private HouseService houses = new HouseServiceImplementation(new HouseRepository());

    @GetMapping("/house/{houseStudent}")
    public String houseStudent(@PathVariable String houseStudent, Model model) {
        model.addAttribute("house", houses.getHouseByName(houseStudent));
        model.addAttribute("students", students.getStudentsByHouse(houseStudent));
        return "Students-House";
    }

    @GetMapping("/houseStudent")
    public String studentRequestedPram(@RequestParam(value ="name") String name, Model model) {
        model.addAttribute("student", students.getStudentByName(name));
        return "StudentDetalled";
    }

    @GetMapping("/StudentD/{name}")
    public String getHouse(Model model, @PathVariable String name) {
        model.addAttribute("student",students.getStudentByName(name));
        return "StudentDetalled";
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", students.getStudents());
        return "index";
    }

    @GetMapping("/house/createstudent/{name}")
    public String students(@PathVariable String name, Model model) {
        model.addAttribute("house", houses.getHouseByName(name));
        model.addAttribute("student", new Student());
        return "Student-create";
    }

    @PostMapping("/house/createstudent/{name}")
    public String createStudent(Student student, @PathVariable String name) {
        student.setHouse(houses.getHouseByName(name));
        students.addStudent(student);
        return "redirect:/house/{name}";
    }

    @GetMapping("/student/update/{name}")
    public String updateStudent(@PathVariable String name, Model model) {
        model.addAttribute("student", students.getStudentByName(name));
        model.addAttribute("houses", houses.getHouses());
        return "update-student";
    }


    @PostMapping("/student/update/{name}")
    public String updateStudent(@PathVariable String name, Student student) {
        students.updateStudent(student, name);
        return "redirect:/";
    }
}
