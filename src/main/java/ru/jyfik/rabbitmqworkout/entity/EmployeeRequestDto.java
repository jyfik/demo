package ru.jyfik.rabbitmqworkout.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("documentSerial")
    private String documentSerial;

    @JsonProperty("documentNumber")
    private String documentNumber;

}
