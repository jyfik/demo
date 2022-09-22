package ru.jyfik.rabbitmqworkout.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.jyfik.rabbitmqworkout.entity.EmployeeDto;
import ru.jyfik.rabbitmqworkout.entity.EmployeeEntity;
import ru.jyfik.rabbitmqworkout.entity.EmployeeRequestDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-21T10:27:14+0300",
    comments = "version: 1.5.0.Beta2, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.2.jar, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeEntity dtoToEmployeeEntity(EmployeeDto source) {
        if ( source == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setLastName( source.getLastName() );
        employeeEntity.setFirstName( source.getFirstName() );
        employeeEntity.setMiddleName( source.getMiddleName() );
        employeeEntity.setDocumentNumber( source.getDocumentNumber() );
        employeeEntity.setDocumentSerial( source.getDocumentSerial() );

        return employeeEntity;
    }

    @Override
    public EmployeeRequestDto entityToEmployeeRequestDto(EmployeeEntity source) {
        if ( source == null ) {
            return null;
        }

        EmployeeRequestDto.EmployeeRequestDtoBuilder employeeRequestDto = EmployeeRequestDto.builder();

        employeeRequestDto.id( source.getId() );
        employeeRequestDto.lastName( source.getLastName() );
        employeeRequestDto.firstName( source.getFirstName() );
        employeeRequestDto.documentSerial( source.getDocumentSerial() );
        employeeRequestDto.documentNumber( source.getDocumentNumber() );

        return employeeRequestDto.build();
    }
}
