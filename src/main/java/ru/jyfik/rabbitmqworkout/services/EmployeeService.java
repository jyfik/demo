package ru.jyfik.rabbitmqworkout.services;

import org.springframework.stereotype.Service;
import ru.jyfik.rabbitmqworkout.entity.EmployeeDto;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Service
public interface EmployeeService {

    void createEmployee(EmployeeDto employee);

    void createAndSend(EmployeeDto employee);
}
