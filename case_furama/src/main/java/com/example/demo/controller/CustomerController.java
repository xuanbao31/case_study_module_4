package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerType;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/customers")
    public String listUsers(@PageableDefault(value = 2) Pageable pageable, Model model) {
        model.addAttribute("customers", customerService.findAll(pageable));
        return "/customer/list";
    }

    @GetMapping("/search")
    public String searchName(@PageableDefault Pageable pageable,
                             @RequestParam String name, Model model) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);

        model.addAttribute("customers", customerService.findByName(pageable, name));
        return "/customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    //
    @PostMapping("/create")
    public String createStudent(@ModelAttribute Customer customer,
                                RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        return "redirect:/customers";
        //return "forward:/student";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteFormCustomer(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "customer/delete";
    }
        @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.remove(customer.getId());
        return "redirect:/customers";
    }

    //
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int  id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        return "redirect:/customers";
    }


}
