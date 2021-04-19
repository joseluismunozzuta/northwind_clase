package com.example.demo.controller;

import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping(value = {"", "/"})
    public String cantidadEmpleadosPorRegion(Model model) {

        model.addAttribute("listaEmpleadosPorRegion", employeeRepository.obtenerEmpleadosPorRegion());
        return "employee/estadistica";
    }

    @PostMapping(value = "/BuscarEmpleadoRegion")
    public String buscarEmpleadoPorRegion(Model model, @RequestParam("searchField") String nombre) {
        model.addAttribute("listaEmpleadosPorRegion", employeeRepository.obtenerEmpleadosPorRegionPorNombre(nombre));
        model.addAttribute("nombreBusqueda",nombre);
        return "employee/estadistica";
    }
}
