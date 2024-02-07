package ru.dmalomoshin.homework4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class SuperController {

    @RequestMapping("/dice")
    public String task2(Model model) {
        Random random = new Random();
        model.addAttribute("number", random.nextInt(1, 7));
        return "dice";
    }

}
