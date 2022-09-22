package ru.jyfik.rabbitmqworkout.services;

import org.springframework.stereotype.Service;
import ru.jyfik.rabbitmqworkout.entity.CompanyStuffEntity;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Service
public interface CompanyStuffService {

    void createStuff(CompanyStuffEntity entity);
}
