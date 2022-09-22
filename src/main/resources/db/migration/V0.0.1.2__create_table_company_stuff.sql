create table if not exists company_stuff
(
    id                  serial not null,
    employee_id         bigint not null,
    first_name          varchar(20) not null,
    last_name           varchar(20) not null,
    document_serial     varchar(6) not null,
    constraint pk_stuff_id primary key (id),
    constraint fk_employee_id foreign key (employee_id)
        references employee(id)
        on delete set null
)