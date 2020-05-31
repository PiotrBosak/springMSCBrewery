package pb.spring.springMSCBrewery.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pb.spring.springMSCBrewery.web.model.BeerDto;
import pb.spring.springMSCBrewery.web.service.BeerService;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Validated
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
    public ResponseEntity<BeerDto> handlePost(@Valid @RequestBody BeerDto dto) {
        var savedBeer = service.postBeer(dto);
        if (savedBeer.getBeerStyle() != null) {
            var headers = new HttpHeaders();
            headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity handleUpdate(@PathVariable("id") UUID id, @Valid @RequestBody BeerDto beerDto) {
        service.updateBeer(id, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }




}
