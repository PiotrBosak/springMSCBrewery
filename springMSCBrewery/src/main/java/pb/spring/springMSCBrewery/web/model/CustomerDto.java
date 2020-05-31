package pb.spring.springMSCBrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    @Null
    private UUID id;
    @Size(min = 3, max = 100)
    @NotBlank
    private String firstName;
    @NotBlank
    @Size(min = 3, max = 100)
    private String lastName;

}
