package com.springrestmvcproject.spring6restmvc.service;

import com.springrestmvcproject.spring6restmvc.model.Beer;

import java.util.UUID;


public interface BeerService {

    Beer getBeerById(UUID id);

}
