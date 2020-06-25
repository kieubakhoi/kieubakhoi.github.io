package com.assignment.java5.controller;


import com.assignment.java5.model.Customer;
import com.assignment.java5.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@RequestMapping("customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("create-customer")
    public ModelAndView saveCustomer() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/customer/list-customer");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully!");
        return modelAndView;
    }

    @GetMapping("list-customer")
    public String listCustomer(Model model) {
        List<Customer> list = customerService.findAll();
        model.addAttribute("list", list);
        model.addAttribute("message", "List showed successfully!!!");
        return "customer/list";
    }

    @GetMapping("editCustomer/{id}")
    public String editCustomer(Model model, @PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("message", "Edit showed!!!");
        return "customer/edit";
    }

    @PostMapping("editCustomer")
    public String doEdit(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/list-customer";
    }
    @GetMapping("removeCustomer/{id}")
    public String doDelete(@PathVariable("id") Long id){
        customerService.remove(id);
        return "redirect:/customer/list-customer";

    }

    @GetMapping("index")
    public String index() {
        return "customer/index";
    }
}
