package pb.spring.springMSCBrewery.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pb.spring.springMSCBrewery.web.model.BeerDto;
import pb.spring.springMSCBrewery.web.service.BeerService;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private final BeerService service;

    public BeerController(BeerService service) {
        this.service = service;
    }

    @GetMapping("")
    private String getSth() {
        return "sth";
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(service.getBeer(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> handlePost(BeerDto dto) {
        var savedBeer = service.postBeer(dto);
        if (savedBeer.getId() != null) {
            var headers = new HttpHeaders();
            headers.add("Location","/api/v1/beer/"+savedBeer.getId().toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
