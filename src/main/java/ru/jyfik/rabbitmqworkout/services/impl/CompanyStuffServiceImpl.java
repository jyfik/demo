package ru.jyfik.rabbitmqworkout.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jyfik.rabbitmqworkout.entity.CompanyStuffEntity;
import ru.jyfik.rabbitmqworkout.repository.CompanyStuffRepository;
import ru.jyfik.rabbitmqworkout.services.CompanyStuffService;
import javax.transaction.Transactional;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyStuffServiceImpl implements CompanyStuffService {

    private final CompanyStuffRepository repository;

    @Override
    public void createStuff(CompanyStuffEntity entity) {
        repository.save(entity);
    }
}
