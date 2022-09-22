package ru.jyfik.rabbitmqworkout.controllers;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jyfik.rabbitmqworkout.entity.EmployeeDto;
import ru.jyfik.rabbitmqworkout.services.EmployeeService;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Api(value = "API для создания сотрудников")
@RestController
@RequestMapping("/api/rest/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Void> createEmployee(@RequestBody EmployeeDto employee) {
        employeeService.createEmployee(employee);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/create-and-send")
    public ResponseEntity<Void> createAndSendEmployeeToOtherModule(@RequestBody EmployeeDto employee) {
        employeeService.createAndSend(employee);

        return ResponseEntity.ok().build();
    }
}
