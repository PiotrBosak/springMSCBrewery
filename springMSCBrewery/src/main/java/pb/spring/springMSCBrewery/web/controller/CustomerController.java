package pb.spring.springMSCBrewery.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pb.spring.springMSCBrewery.web.model.BeerDto;
import pb.spring.springMSCBrewery.web.model.CustomerDto;
import pb.spring.springMSCBrewery.web.service.CustomerService;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer( @PathVariable("id") UUID customerId) {
        var customer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpHeaders> handlePost( @Valid @RequestBody CustomerDto customer) {
        var newCustomer = customerService.postCustomer(customer);
        var headers = new HttpHeaders();
        headers.add("Location", "api/customer" + newCustomer.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handlePut(@PathVariable("id") UUID id,@Valid  @RequestBody CustomerDto body) {
        customerService.putCustomer(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("id") UUID id) {
        customerService.deleteCustomer(id);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> handleException(ConstraintViolationException e) {
        var errors = (e.getConstraintViolations()
                .stream()
                .map(c -> c.getPropertyPath() + " : " + c.getMessage())
                .collect(Collectors.toList()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);


    }

}
