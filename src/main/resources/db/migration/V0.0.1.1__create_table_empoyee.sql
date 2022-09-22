create table employee
(
    id                  serial not null,
    last_name           varchar(20) not null,
    first_name          varchar(20) not null,
    middle_name         varchar(20),
    document_number     varchar(4) not null,
    document_serial     varchar(6) not null,
    is_send_status      boolean,
    constraint pk_employee_num primary key (id)
);