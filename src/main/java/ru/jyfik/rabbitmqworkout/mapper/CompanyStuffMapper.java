package ru.jyfik.rabbitmqworkout.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.jyfik.rabbitmqworkout.entity.CompanyStuffEntity;
import ru.jyfik.rabbitmqworkout.entity.EmployeeRequestDto;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */
@Mapper(componentModel = "spring")
public interface CompanyStuffMapper {

    @Mapping(source = "source", target = "employee")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "documentSerial", target = "documentSerial")
    CompanyStuffEntity dtoToEntity(EmployeeRequestDto source);
}
