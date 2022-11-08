package com.example.demo.controller;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.CustomerType;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public String listUsers(@PageableDefault(value = 4) Pageable pageable, Model model) {
        model.addAttribute("customers", customerService.findAll(pageable));
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        return "/customer/list";
    }

    @GetMapping("/search")
    public String searchName(@PageableDefault(value = 4) Pageable pageable,
                             @RequestParam String name, Model model) {
//        List<CustomerType> customerTypes = customerTypeService.findAll();
//        model.addAttribute("customerTypeList", customerTypes);
        model.addAttribute("customers", customerService.findByName(pageable, name));
        model.addAttribute("name", name);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    //
    @PostMapping("/create")
    public String createStudent(@ModelAttribute Customer customer,
                                RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        return "redirect:/customer/list";
        //return "forward:/student";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteFormCustomer(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.remove(customer.getId());
        return "redirect:/customer/list";
    }

    //
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypes", customerTypeService.findAll());
            return "/customer/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        return "redirect:/customer/list";
    }


}
