package pb.spring.springMSCBrewery.web.service;

import pb.spring.springMSCBrewery.web.model.BeerDto;

import java.util.UUID;

public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeer(UUID id) {
        return BeerDto.builder()
                .id(id)
                .beerName("whatever")
                .beerStyle("some style")
                .build();
    }
}
