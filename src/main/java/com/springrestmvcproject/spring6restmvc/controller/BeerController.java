package com.springrestmvcproject.spring6restmvc.controller;


import com.springrestmvcproject.spring6restmvc.model.Beer;
import com.springrestmvcproject.spring6restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {


    private final BeerService beerService;

    public Beer getBearById(UUID id) {

        log.debug("Get Beer By Id : Inside Controller");
        return beerService.getBeerById(id);


    }


}
