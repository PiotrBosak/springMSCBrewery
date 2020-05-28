package pb.spring.springMSCBrewery.web.service;

import org.springframework.stereotype.Service;
import pb.spring.springMSCBrewery.web.model.CustomerDto;

import java.util.UUID;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomer(UUID id) {
        return CustomerDto.builder()
                .id(id)
                .firstName("johnny")
                .lastName("smith")
                .build();
    }

    @Override
    public CustomerDto postCustomer(CustomerDto customerDto) {
        System.out.println(customerDto.getFirstName());
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .build();
    }

    @Override
    public void putCustomer(UUID id, CustomerDto body) {
        System.out.println("put");
    }

    @Override
    public void deleteCustomer(UUID id) {
        System.out.println("deleted");
    }
}
