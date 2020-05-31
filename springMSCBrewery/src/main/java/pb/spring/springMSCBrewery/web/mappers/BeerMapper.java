package pb.spring.springMSCBrewery.web.mappers;

import org.mapstruct.Mapper;
import pb.spring.springMSCBrewery.domain.Beer;
import pb.spring.springMSCBrewery.web.model.BeerDto;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
