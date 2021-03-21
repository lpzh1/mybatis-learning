


create table t_customer(
    id int primary key auto_increment,
    name varchar(16),
    code char(16),
    status char(16),
    create_date datetime,
    last_update datetime
) ;