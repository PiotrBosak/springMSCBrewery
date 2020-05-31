package pb.spring.springMSCBrewery.web.mappers;

import org.mapstruct.Mapper;
import pb.spring.springMSCBrewery.domain.Customer;
import pb.spring.springMSCBrewery.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);
}
