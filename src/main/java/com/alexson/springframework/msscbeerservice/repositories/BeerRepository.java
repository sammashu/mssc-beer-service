package com.alexson.springframework.msscbeerservice.repositories;

import com.alexson.springframework.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository  extends PagingAndSortingRepository<Beer, UUID> {
}
