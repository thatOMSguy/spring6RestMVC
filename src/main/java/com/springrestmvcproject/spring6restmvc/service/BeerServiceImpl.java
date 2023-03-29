package com.springrestmvcproject.spring6restmvc.service;

import com.springrestmvcproject.spring6restmvc.model.Beer;
import com.springrestmvcproject.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get bear by id service initiated");

        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("123")
                .price(new BigDecimal("12.995"))
                .quantityOnHand(122)
                .createDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }
}
