package org.example.harrypotter.controllers;

import org.example.harrypotter.entities.House;
import org.example.harrypotter.repositories.HouseRepository;
import org.example.harrypotter.services.HouseService;
import org.example.harrypotter.services.HouseServiceImplementation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Houses {
    private HouseService houses = new HouseServiceImplementation(new HouseRepository());

    @GetMapping("/houses")
    public String houses(Model model) {
        List<House> houseList = houses.getHouses();
        model.addAttribute("houses", houseList);
        return "Houses-Hogwarts";
    }

    @GetMapping("/houseD/{name}")
    public String getHouse(Model model, @PathVariable String name) {
        model.addAttribute("house",houses.getHouseByName(name));
        return "HouseDetalled";
    }

    @GetMapping("/houses/create")
    public String createHouse(Model model) {
        model.addAttribute("house", new House());
        return "create-house";
    }

    @PostMapping("/houses/create")
    public String createHouse(House house) {
        houses.addHouse(house);
        return "redirect:/houses";
    }

    @GetMapping("/house/update/{name}")
    public String updateBook(@PathVariable String name, Model model) {
        model.addAttribute("house", houses.getHouseByName(name));
        return "update-house";
    }

    @PostMapping("/house/update/{name}")
    public String updateBook(@PathVariable String name, House house) {
        houses.updateHouse(name, house);
        return "redirect:/houses";
    }

    @GetMapping("/house/delete/{name}")
    public String deleteBook(@PathVariable String name) {
        houses.deleteHouse(name);
        return "redirect:/houses";
    }



}
