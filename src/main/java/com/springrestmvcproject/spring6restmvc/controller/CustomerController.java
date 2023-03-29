package com.springrestmvcproject.spring6restmvc.controller;



import com.springrestmvcproject.spring6restmvc.model.Customer;
import com.springrestmvcproject.spring6restmvc.model.Customer;
import com.springrestmvcproject.spring6restmvc.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {


    private final CustomerService customerService;

    @PatchMapping("{customerId}")
    public ResponseEntity updateCustomerPatchById(@PathVariable("customerId") UUID customerId, Customer customer) {

        customerService.patchCustomerById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);


    }

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteById(@PathVariable("customerId") UUID customerId){

        customerService.deleteCustomerById(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customerId}")
    public ResponseEntity updateById(@PathVariable("customerId")UUID customerId, @RequestBody Customer Customer){
        customerService.updateCustomerById(customerId, Customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer){
        Customer savedCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers =new HttpHeaders();
        headers.add("Location",
                "/api/v1/customer/"+savedCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);

    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers() {

        return customerService.listCustomers();

    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId) {

        log.debug("Get Customer By Id : Inside Controller");
        return customerService.getCustomerById(customerId);


    }


}
