package ru.jyfik.rabbitmqworkout.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.jyfik.rabbitmqworkout.entity.EmployeeDto;
import ru.jyfik.rabbitmqworkout.entity.EmployeeEntity;
import ru.jyfik.rabbitmqworkout.entity.EmployeeRequestDto;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "documentNumber", target = "documentNumber")
    @Mapping(source = "documentSerial", target = "documentSerial")
    EmployeeEntity dtoToEmployeeEntity(EmployeeDto source);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "documentSerial", target = "documentSerial")
    @Mapping(source = "documentNumber", target = "documentNumber")
    EmployeeRequestDto entityToEmployeeRequestDto(EmployeeEntity source);
}
