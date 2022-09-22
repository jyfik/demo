package ru.jyfik.rabbitmqworkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.jyfik.rabbitmqworkout.entity.EmployeeEntity;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
