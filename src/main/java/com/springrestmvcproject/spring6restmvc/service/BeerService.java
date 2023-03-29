package com.springrestmvcproject.spring6restmvc.service;

import com.springrestmvcproject.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;


public interface BeerService {

    List<Beer> listBeers();

    Beer getBeerById(UUID id);

}
