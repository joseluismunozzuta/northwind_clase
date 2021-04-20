package com.example.demo.controller;

import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping(value = {"", "/"})
    public String cantidadOrdenesPorCategoria(Model model) {

        model.addAttribute("listaOrdenesPorCategoria", categoryRepository.obtenerOrdenesPorCategoria());
        return "category/estadistica";
    }

}
