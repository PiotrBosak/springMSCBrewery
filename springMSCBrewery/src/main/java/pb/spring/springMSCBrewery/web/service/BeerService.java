package pb.spring.springMSCBrewery.web.service;

import org.springframework.stereotype.Service;
import pb.spring.springMSCBrewery.web.model.BeerDto;

import java.util.UUID;
@Service
public interface BeerService {

    BeerDto getBeer(UUID id);
    BeerDto postBeer(BeerDto request);
}
