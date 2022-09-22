package ru.jyfik.rabbitmqworkout.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.jyfik.rabbitmqworkout.entity.EmployeeDto;
import ru.jyfik.rabbitmqworkout.entity.EmployeeEntity;
import ru.jyfik.rabbitmqworkout.entity.EmployeeRequestDto;
import ru.jyfik.rabbitmqworkout.mapper.EmployeeMapper;
import ru.jyfik.rabbitmqworkout.repository.EmployeeRepository;
import ru.jyfik.rabbitmqworkout.services.EmployeeService;
import javax.transaction.Transactional;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final ObjectMapper objectMapper;
    private final RabbitTemplate template;

    @Override
    public void createEmployee(EmployeeDto employee) {
        employeeRepository.saveAndFlush(employeeMapper.dtoToEmployeeEntity(employee));
    }

    @Override
    public void createAndSend(EmployeeDto employee) {
        EmployeeEntity savedEmployee = employeeRepository.saveAndFlush(employeeMapper.dtoToEmployeeEntity(employee));

        sendAndChangeSendStatus(savedEmployee);
    }

    private void sendAndChangeSendStatus(EmployeeEntity employeeEntity) {

        try {
            EmployeeRequestDto requestDto = transformEntityToRequestDto(employeeEntity);

            template.convertAndSend("stuff", new Message(objectMapper.writeValueAsBytes(requestDto)));
        } catch (JsonProcessingException ignore) {

        }

        employeeEntity.setSendStatus(true);
        employeeRepository.save(employeeEntity);
    }

    private EmployeeRequestDto transformEntityToRequestDto(EmployeeEntity employeeEntity) {
        return employeeMapper.entityToEmployeeRequestDto(employeeEntity);
    }
}
