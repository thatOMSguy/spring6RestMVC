package com.springrestmvcproject.spring6restmvc.controller;


import com.springrestmvcproject.spring6restmvc.model.Customer;
import com.springrestmvcproject.spring6restmvc.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {


    private final CustomerService customerService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers() {

        return customerService.listCustomers();

    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getBearById(@PathVariable("customerId") UUID customerId) {

        log.debug("Get Customer By Id : Inside Controller");
        return customerService.getCustomerById(customerId);


    }


}
