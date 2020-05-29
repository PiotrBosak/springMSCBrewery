package pb.spring.springMSCBrewery.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pb.spring.springMSCBrewery.web.model.BeerDto;

import java.util.UUID;
@Slf4j
@Service
@Primary
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeer(UUID id) {
        return BeerDto.builder()
                .id(id)
                .beerName("whatever")
                .beerStyle("some style")
                .build();
    }

    @Override
    public BeerDto postBeer(BeerDto request) {
        System.out.println(request.getBeerName());
        try {
            return BeerDto.builder()
                    .id(UUID.randomUUID())
                    .beerName(request.getBeerName())
                    .beerStyle(request.getBeerStyle())
                    .upc(request.getUpc())
                    .build();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateBeer(UUID id, BeerDto beerDto) {
        //todo add real impl

    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleted a beer");
    }
}


