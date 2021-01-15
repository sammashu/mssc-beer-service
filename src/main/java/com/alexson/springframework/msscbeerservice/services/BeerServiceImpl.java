package com.alexson.springframework.msscbeerservice.services;

import com.alexson.springframework.msscbeerservice.domain.Beer;
import com.alexson.springframework.msscbeerservice.repositories.BeerRepository;
import com.alexson.springframework.msscbeerservice.web.controller.NotFoundException;
import com.alexson.springframework.msscbeerservice.web.mappers.BeerMapper;
import com.alexson.springframework.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.BeerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {

        return beerMapper.BeerToBeerDto(beerRepository.save(beerMapper.BeerDtoToBeer(beerDto))) ;
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository. findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.BeerToBeerDto(beerRepository.save(beer));
    }
}
