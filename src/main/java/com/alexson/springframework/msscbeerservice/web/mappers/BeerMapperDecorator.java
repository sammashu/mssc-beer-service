package com.alexson.springframework.msscbeerservice.web.mappers;

import com.alexson.springframework.msscbeerservice.domain.Beer;
import com.alexson.springframework.msscbeerservice.services.inventory.BeerInventoryService;
import com.alexson.springframework.msscbeerservice.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator implements BeerMapper {

    private BeerInventoryService beerInventoryService;
    private BeerMapper mapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerDto BeerToBeerDto(Beer beer) {
        BeerDto dto = mapper.BeerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
        return dto;
    }

    @Override
    public Beer BeerDtoToBeer(BeerDto beerDto) {
        return mapper.BeerDtoToBeer(beerDto);
    }
}
