package com.springrestmvcproject.spring6restmvc.controller;


import com.springrestmvcproject.spring6restmvc.model.Beer;
import com.springrestmvcproject.spring6restmvc.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {


    private final BeerService beerService;

    @PostMapping
   // @RequestMapping(method = RequestMethod.POST)//or just use @postmappin
    public ResponseEntity handlePost(@RequestBody Beer beer){
        Beer savedBeer = beerService.saveNewBeer(beer);
        return new ResponseEntity(HttpStatus.CREATED);

    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers(){

        return beerService.listBeers();

    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Beer getBearById(@PathVariable("beerId") UUID beerId) {

        log.debug("Get Beer By Id : Inside Controller -1234 --aasssddfff");
        return beerService.getBeerById(beerId);


    }


}
