package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/customers/new")
    public String createCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create";
    }

    @PostMapping("/customers")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{BankID}")
    public String editCustomerForm(@PathVariable Long BankID, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(BankID));
        return "edit_customer";
    }

    @PostMapping("/customers/update/{BankID}")
    public String updateCustomer(@PathVariable Long BankID, @ModelAttribute("customer") Customer customer) {
        Customer existingCustomer = customerService.getCustomerById(BankID);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        customerService.updateCustomer(existingCustomer);
        return "redirect:/customers";
    }

    @GetMapping("/customers/delete/{BankID}")
    public String deleteCustomer(@PathVariable Long BankID) {
        customerService.deleteCustomerById(BankID);
        return "redirect:/customers";
    }
}
