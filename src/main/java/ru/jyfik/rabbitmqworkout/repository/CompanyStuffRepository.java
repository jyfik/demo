package ru.jyfik.rabbitmqworkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jyfik.rabbitmqworkout.entity.CompanyStuffEntity;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Repository
public interface CompanyStuffRepository extends JpaRepository<CompanyStuffEntity, Long> {
}
