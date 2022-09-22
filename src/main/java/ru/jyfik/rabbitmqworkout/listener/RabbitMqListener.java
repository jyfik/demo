package ru.jyfik.rabbitmqworkout.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.jyfik.rabbitmqworkout.entity.EmployeeRequestDto;
import ru.jyfik.rabbitmqworkout.processor.EventProcessor;
import java.io.IOException;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Slf4j
@Component
@EnableRabbit
@RequiredArgsConstructor
public class RabbitMqListener {

    private final EventProcessor eventProcessor;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "employee")
    public void handle(Message message) {
        try {
            EmployeeRequestDto employeeRequestDto = objectMapper.readValue(message.getBody(), EmployeeRequestDto.class);

            log.info("Message received from queue: \"employee\". Data: " + employeeRequestDto.toString());

            eventProcessor.process(employeeRequestDto);
        } catch (IOException ignore) {

        }

    }
}
