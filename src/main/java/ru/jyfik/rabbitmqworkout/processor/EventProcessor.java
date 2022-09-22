package ru.jyfik.rabbitmqworkout.processor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.jyfik.rabbitmqworkout.entity.EmployeeRequestDto;
import ru.jyfik.rabbitmqworkout.mapper.CompanyStuffMapper;
import ru.jyfik.rabbitmqworkout.services.CompanyStuffService;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EventProcessor {

    private final CompanyStuffService service;
    private final CompanyStuffMapper mapper;

    public void process(EmployeeRequestDto dto) {
        service.createStuff(mapper.dtoToEntity(dto));
    }
}
