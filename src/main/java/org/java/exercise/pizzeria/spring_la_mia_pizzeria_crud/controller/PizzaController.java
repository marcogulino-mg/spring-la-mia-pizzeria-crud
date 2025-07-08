package org.java.exercise.pizzeria.spring_la_mia_pizzeria_crud.controller;

import java.util.List;
import org.java.exercise.pizzeria.spring_la_mia_pizzeria_crud.model.Pizza;
import org.java.exercise.pizzeria.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/{id}")
    public String getMethodName(@PathVariable("id") int id, Model model) {
        model.addAttribute("pizza", repository.findById(id).get());
        return "pizzas/show";
    }

}
