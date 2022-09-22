package ru.jyfik.rabbitmqworkout.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Data
public class EmployeeDto {

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("documentNumber")
    private String documentNumber;

    @JsonProperty("documentSerial")
    private String documentSerial;
}
