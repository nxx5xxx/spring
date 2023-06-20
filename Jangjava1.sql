--create user jangjava1 identified by 1234;
--grant dba,resource,connect to jangjava1;

create table spring_test(
        data1 varchar2(100) not null,
        data2 varchar2(100) not null,
        data3 varchar2(100) not null
        );

insert into spring_test values('강아지','고양이','사자');

commit;

select * from spring_test;

