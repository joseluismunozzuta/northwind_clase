package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/product")
    public String productList(Model model){

        model.addAttribute("listaProductos", productRepository.findAll());

        return "product/list";
    }

    @GetMapping("/product/new")
    public String productNew(@ModelAttribute("product") Product product, Model model){
        model.addAttribute("listaCategorias",categoryRepository.findAll());
        return "product/newForm";
    }

    @PostMapping("/product/save")
    public String productSave(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, Model model, RedirectAttributes attr){

        if(bindingResult.hasErrors()) {
            model.addAttribute("listaCategorias",categoryRepository.findAll());
            return "product/newForm";
        }else{
            if(product.getId() == 0 ){
                attr.addFlashAttribute("msg","Producto creado exitosamente");
            }else{
                attr.addFlashAttribute("msg","Producto actualizado exitosamente");
            }
            productRepository.save(product);
            return "redirect:/product";
        }
    }


    @GetMapping("/product/edit")
    public String editProduct(@ModelAttribute("product") Product product, @RequestParam("id") int id, Model model){

        Optional<Product> productOpt = productRepository.findById(id);

        if(productOpt.isPresent()){
            product = productOpt.get();
            model.addAttribute("product",product);
            model.addAttribute("listaCategorias",categoryRepository.findAll());
            return "product/newForm";
        }else{
            return "redirect:/product";
        }
    }

    @GetMapping("/product/borrar")
    public String borrarProduct(@RequestParam("id") int id, RedirectAttributes attr1) {

        Optional<Product> productOpt = productRepository.findById(id);

        if (productOpt.isPresent()) {
            productRepository.deleteById(id);
            attr1.addFlashAttribute("msg","Producto borrado exitosamente");
        }
        return "redirect:/product";
    }

}
