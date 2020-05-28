package pb.spring.springMSCBrewery.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    private String getSth(){
        return "sth";
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(service.getBeer(beerId), HttpStatus.OK);
    }




}
