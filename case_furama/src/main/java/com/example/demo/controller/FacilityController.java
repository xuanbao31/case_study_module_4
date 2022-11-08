package com.example.demo.controller;

import com.example.demo.model.facility.Facility;
import com.example.demo.model.facility.FacilityType;
import com.example.demo.model.facility.RentType;
import com.example.demo.service.IFacilityService;
import com.example.demo.service.IFacilityTypeService;
import com.example.demo.service.IRentTypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/list")
    public String showFacility(@PageableDefault(value = 2) Pageable pageable, Model model) {
        model.addAttribute("facility", facilityService.findAll(pageable));
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("facilityType", facilityTypeList);
        List<RentType> rentTypeList = rentTypeService.findAll();
        model.addAttribute("rentType", rentTypeList);
        return "/facility/list";
    }

    @GetMapping("/createVilla")
    public String addVilla(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/facility/villa";
    }
    @GetMapping("/createHouse")
    public String addHouse(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/facility/house";
    }
    @GetMapping("/createRoom")
    public String addRoom(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/facility/room";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute Facility facility) {
        facilityService.save(facility);
        return "redirect:/facility/list";
    }


    @GetMapping("/search")
    public String searchName(@PageableDefault(value = 2) Pageable pageable,
                             @RequestParam String name,
                             Model model) {
        model.addAttribute("facility", facilityService.findName(pageable, name));
        model.addAttribute("name", name);
        return "/facility/list";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("facility", facilityService.findById(id));
        model.addAttribute("facilityType", facilityTypeService.findAll());
        model.addAttribute("rentType", rentTypeService.findAll());
        return "/facility/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Facility facility) {
        facilityService.save(facility);
        return "redirect:/facility/list";
    }

//    @GetMapping("{id}/delete")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("facility", facilityService.findById(id));
//        return "/facility/delete";
//    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "deleteId") int facilityId) {
        facilityService.remove(facilityId);
        return "redirect:/facility/list";
    }

}
