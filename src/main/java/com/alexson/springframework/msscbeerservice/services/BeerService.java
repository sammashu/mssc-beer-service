package com.alexson.springframework.msscbeerservice.services;

import com.alexson.springframework.msscbeerservice.web.model.BeerDto;
import com.alexson.springframework.msscbeerservice.web.model.BeerPagedList;
import com.alexson.springframework.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {
    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);

    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
