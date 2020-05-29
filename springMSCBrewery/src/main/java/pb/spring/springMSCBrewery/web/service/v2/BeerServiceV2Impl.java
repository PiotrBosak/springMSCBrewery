package pb.spring.springMSCBrewery.web.service.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pb.spring.springMSCBrewery.web.model.BeerDto;
import pb.spring.springMSCBrewery.web.model.v2.BeerDtoV2;
import pb.spring.springMSCBrewery.web.model.v2.BeerStyle;
import pb.spring.springMSCBrewery.web.service.BeerService;

import java.util.UUID;

@Slf4j
@Service
@Primary
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeer(UUID id) {
        return BeerDtoV2.builder()
                .id(id)
                .beerName("whatever")
                .beerStyle(BeerStyle.ALE)
                .build();
    }

    @Override
    public BeerDtoV2 postBeer(BeerDtoV2 request) {
        System.out.println(request.getBeerName());
        try {//try is not useful here
            return BeerDtoV2.builder()
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
    public void updateBeer(UUID id, BeerDtoV2 beerDto) {
        //todo add real impl

    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleted a beer");
    }
}

