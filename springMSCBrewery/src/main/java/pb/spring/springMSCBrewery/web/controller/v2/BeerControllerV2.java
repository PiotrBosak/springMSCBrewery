package pb.spring.springMSCBrewery.web.controller.v2;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pb.spring.springMSCBrewery.web.model.v2.BeerDtoV2;
import pb.spring.springMSCBrewery.web.service.v2.BeerServiceV2;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 service;

    public BeerControllerV2(BeerServiceV2 service) {
        this.service = service;
    }

    @GetMapping("")
    private String getSth() {
        return "sth";
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(service.getBeer(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDtoV2> handlePost(@RequestBody BeerDtoV2 dto) {
        var savedBeer = service.postBeer(dto);
        if (savedBeer.getBeerStyle() != null) {
            var headers = new HttpHeaders();
            headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity handleUpdate(@PathVariable("id") UUID id, @RequestBody BeerDtoV2 beerDto) {
        service.updateBeer(id, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }


}