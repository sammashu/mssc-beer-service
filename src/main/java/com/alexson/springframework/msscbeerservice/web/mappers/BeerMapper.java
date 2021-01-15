package com.alexson.springframework.msscbeerservice.web.mappers;

import com.alexson.springframework.msscbeerservice.domain.Beer;
import com.alexson.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { DateMapper.class })
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDto beerDto);
}
