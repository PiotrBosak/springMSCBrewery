package pb.spring.springMSCBrewery.web.service;

import org.springframework.stereotype.Service;
import pb.spring.springMSCBrewery.web.model.BeerDto;

import java.util.UUID;
@Service
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
