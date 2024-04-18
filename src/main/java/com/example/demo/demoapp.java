package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@SpringBootApplication
public class demoapp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(demoapp.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Customer customer1 = new Customer("firstname1", "lastnamename1", "name1@gmail.com");
        customerRepository.save(customer1);
        Customer customer2 = new Customer("firstname2", "lastnamename2", "name2@gmail.com");
        customerRepository.save(customer2);
        Customer customer3 = new Customer("firstname3", "lastnamename3", "name3@gmail.com");
        customerRepository.save(customer3);
    }
    
}