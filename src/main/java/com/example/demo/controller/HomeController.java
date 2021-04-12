package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/alumno")
public class HomeController {

    @RequestMapping(value="",method=RequestMethod.GET)
    public String paginaPrincipal(){

        return "paginaPrincipal";
    }

    @RequestMapping(value="/nuevo",method=RequestMethod.GET)
    public String nuevoAlumno(Model model,
                              @RequestParam(name = "numero", required = false) String number,
                              @RequestParam(name = "nombre") String nombre){
        int numero = -1;
        try{
            numero = Integer.parseInt(number);
        }catch(NumberFormatException e){

        }
        model.addAttribute("numeroRecibido",numero);
        model.addAttribute("nombreRecibido",nombre);
        System.out.println(numero);
        System.out.println(nombre);

        return "alumno/nuevo";
    }

    @RequestMapping(value={"/pagina2","/p2","/pag2"})
    @ResponseBody
    public String pagina2(){

        return "<h1>Pagina 2: Hola Diego</h1>";

    }

    @PostMapping("/guardar")
    public String guardarAlumno(@RequestParam("nombre") String nombre,
                                @RequestParam("apellido") String apellido,
                                @RequestParam("dni") String dni){

        System.out.println("nombre:" + nombre);
        System.out.println("apellido:"+apellido);
        System.out.println("DNI:"+dni);

        return "redirect:/alumno";
    }

}
