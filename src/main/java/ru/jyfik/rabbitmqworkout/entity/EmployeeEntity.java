package ru.jyfik.rabbitmqworkout.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */

@Entity
@Getter
@Setter
@Table(name = "employee")
public class EmployeeEntity {

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "document_serial")
    private String documentSerial;

    @Column(name = "is_send_status")
    private boolean isSendStatus = false;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    private CompanyStuffEntity companyStuff;

}
