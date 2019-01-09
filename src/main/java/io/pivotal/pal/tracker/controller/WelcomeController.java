package io.pivotal.pal.tracker.controller;

import io.pivotal.pal.tracker.model.Customer;
import io.pivotal.pal.tracker.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class WelcomeController {

    private String message;
    private final CustomerRepository customerRepository;

    public WelcomeController(@Value("${WELCOME_MESSAGE}") String message, CustomerRepository customerRepository) {
        this.message = message;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/")
    public String sayHello() {
        return message;
    }

    @GetMapping("/customer/")
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @PostMapping("/newCustomer/{name}")
    public void newCustomer(@PathVariable("name") String name){
        customerRepository.save(new Customer(name));
    }
}
