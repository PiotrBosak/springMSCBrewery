package pb.spring.springMSCBrewery.web.service.v2;

import org.springframework.stereotype.Service;
import pb.spring.springMSCBrewery.web.model.BeerDto;
import pb.spring.springMSCBrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;
    @Service
    public interface BeerServiceV2 {

        BeerDtoV2 getBeer(UUID id);

        BeerDtoV2 postBeer(BeerDtoV2 request);

        void updateBeer(UUID id, BeerDtoV2 beerDto);

        void deleteById(UUID id);
    }

