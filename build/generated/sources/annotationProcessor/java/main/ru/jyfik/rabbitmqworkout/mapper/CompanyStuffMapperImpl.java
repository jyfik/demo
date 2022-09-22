package ru.jyfik.rabbitmqworkout.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.jyfik.rabbitmqworkout.entity.CompanyStuffEntity;
import ru.jyfik.rabbitmqworkout.entity.EmployeeEntity;
import ru.jyfik.rabbitmqworkout.entity.EmployeeRequestDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-21T10:27:14+0300",
    comments = "version: 1.5.0.Beta2, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.2.jar, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class CompanyStuffMapperImpl implements CompanyStuffMapper {

    @Override
    public CompanyStuffEntity dtoToEntity(EmployeeRequestDto source) {
        if ( source == null ) {
            return null;
        }

        CompanyStuffEntity companyStuffEntity = new CompanyStuffEntity();

        companyStuffEntity.setEmployee( employeeRequestDtoToEmployeeEntity( source ) );
        companyStuffEntity.setLastName( source.getLastName() );
        companyStuffEntity.setFirstName( source.getFirstName() );
        companyStuffEntity.setDocumentSerial( source.getDocumentSerial() );
        companyStuffEntity.setId( source.getId() );

        return companyStuffEntity;
    }

    protected EmployeeEntity employeeRequestDtoToEmployeeEntity(EmployeeRequestDto employeeRequestDto) {
        if ( employeeRequestDto == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setLastName( employeeRequestDto.getLastName() );
        employeeEntity.setFirstName( employeeRequestDto.getFirstName() );
        employeeEntity.setDocumentNumber( employeeRequestDto.getDocumentNumber() );
        employeeEntity.setDocumentSerial( employeeRequestDto.getDocumentSerial() );
        employeeEntity.setId( employeeRequestDto.getId() );

        return employeeEntity;
    }
}
