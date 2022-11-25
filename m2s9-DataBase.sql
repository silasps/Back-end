create table pessoas (
	id serial primary key,
    name varchar(100) not null,
    email varchar(50) not null,
    status boolean default false
)

select * from pessoas

