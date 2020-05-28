package pb.spring.springMSCBrewery.web.service;

import org.springframework.stereotype.Service;
import pb.spring.springMSCBrewery.web.model.CustomerDto;

import java.util.UUID;

@Service
public interface CustomerService {

     CustomerDto getCustomer(UUID id);
}
