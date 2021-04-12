package com.example.demo.controller;

import com.example.demo.entity.Shipper;
import com.example.demo.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ShipperController {

    @Autowired
    ShipperRepository shipperRepository;

    @GetMapping("/shipper")
    public String shipperList(Model model){

        model.addAttribute("shipperList", shipperRepository.findAll());

        return "shipper/list";
    }

    @GetMapping("/shipper/new")
    public String shipperNew(){

        return "shipper/newForm";
    }

    @PostMapping("/shipper/save")
    public String shipperSave(Shipper shipper, RedirectAttributes attr){
        if(shipper.getShipperid() == 0 ){
            attr.addFlashAttribute("msg","Usuario creado exitosamente");
        }else{
            attr.addFlashAttribute("msg","Usuario actualizado exitosamente");
        }

        shipperRepository.save(shipper);
        return "redirect:/shipper";
    }


    @GetMapping("/shipper/edit")
    public String editShipper(@RequestParam("id") int id,Model model){

        Optional<Shipper> shipperOpt = shipperRepository.findById(id);

        if(shipperOpt.isPresent()){
            Shipper shipper = shipperOpt.get();
            model.addAttribute("shipper",shipper);
            return "shipper/editForm";
        }else{
            return "redirect:/shipper";
        }
    }

    @GetMapping("/shipper/borrar")
    public String borrarShipper(@RequestParam("id") int id, RedirectAttributes attr1) {

        Optional<Shipper> shipperOpt = shipperRepository.findById(id);

        if (shipperOpt.isPresent()) {
            shipperRepository.deleteById(id);
            attr1.addFlashAttribute("msg","Usuario borrado exitosamente");
        }
        return "redirect:/shipper";
    }

    @PostMapping("/shipper/search")
    public String searchShipper(@RequestParam("searchName") String searchname, Model model) {

        //List<Shipper> shipperOpt = shipperRepository.findByCompanyname(searchname);
        List<Shipper> shipperOpt = shipperRepository.listarTransportitasPorNombre(searchname);
        model.addAttribute("shipperList",shipperOpt);
        return "shipper/list";
    }
}
