package pb.spring.springMSCBrewery.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pb.spring.springMSCBrewery.web.model.BeerDto;

import java.util.UUID;

@Service
public interface BeerService {

    BeerDto getBeer(UUID id);

    BeerDto postBeer(BeerDto request);

    void updateBeer(UUID id, BeerDto beerDto);

    void deleteById(UUID id);
}
