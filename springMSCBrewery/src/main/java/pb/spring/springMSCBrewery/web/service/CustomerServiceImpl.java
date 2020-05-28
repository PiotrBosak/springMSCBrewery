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
}
