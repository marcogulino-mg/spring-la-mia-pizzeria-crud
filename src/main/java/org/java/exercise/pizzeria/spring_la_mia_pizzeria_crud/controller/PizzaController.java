package org.java.exercise.pizzeria.spring_la_mia_pizzeria_crud.controller;

import java.util.List;
import org.java.exercise.pizzeria.spring_la_mia_pizzeria_crud.model.Pizza;
import org.java.exercise.pizzeria.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public String index(Model model) {
        List<Pizza> pizzas = repository.findAll();
        model.addAttribute("pizzas", pizzas);

        return "pizzas/index";
    }

}
