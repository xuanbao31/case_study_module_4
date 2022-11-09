package com.example.demo.controller;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.customer.CustomerDto;
import com.example.demo.model.customer.CustomerType;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

//
//    @GetMapping("/list")
//    public String listUsers(@PageableDefault(value = 4) Pageable pageable, Model model) {
//        model.addAttribute("customers", customerService.findAll(pageable));
//        List<CustomerType> customerTypes = customerTypeService.findAll();
//        model.addAttribute("customerTypes", customerTypes);
//        return "/customer/list";
//    }

    @GetMapping("/list")
    public String searchName(@PageableDefault(value = 4) Pageable pageable,
                             @RequestParam(value = "name", defaultValue = "") String name,
                             @RequestParam(value = "email", defaultValue = "") String email,
                             @RequestParam(value = "customerType", defaultValue = "") String customerType,
                             Model model) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("customerType", customerType);
        model.addAttribute("customers", customerService.findByName(pageable, name, email, customerType));
        model.addAttribute("customerTypesList", customerTypeService.findAll());
//        model.addAttribute("customers", customerService.findAll(pageable));
        return "/customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("customerTypes", customerTypes);
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }

    //
    @PostMapping("/create")
    public String createStudent(@ModelAttribute @Valid CustomerDto customerDto,
                                BindingResult bindingResult, Model model,
                                RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "/customer/create";
        } else {

            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            return "redirect:/customer/list";
            //return "forward:/student";
        }
    }

    @GetMapping("/delete/{id}")
    public String showDeleteFormCustomer(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerType", customerTypeService.findAll());
        return "customer/delete";
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customer.setStatus(1);
        customerService.save(customer);
//            customerService.remove(customer.getId());
        return "redirect:/customer/list";
    }

    //
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
//        model.addAttribute("customer", customerService.findById(id));
//        model.addAttribute("customerTypes", customerTypeService.findAll());
//        return "/customer/edit";
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "/customer/edit";
    }

    //    @PostMapping("/edit")
//    public String update(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
//        customerService.save(customer);
//        return "redirect:/customer/list";
//    }
    @PostMapping("/edit")
    public String update(@ModelAttribute @Valid CustomerDto customerDto, Model model) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return "redirect:/customer/list";
    }


}
