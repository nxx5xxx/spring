create table board_info_table(
    board_info_idx number CONSTRAINT board_info_pk primary key,
    board_info_name varchar2(500) not null
    );

insert into board_info_table values(1,'자유게시판');
insert into board_info_table values(2,'유머게시판');
insert into board_info_table values(3,'정치게시판');
insert into board_info_table values(4,'스포츠게시판');

select * from board_info_table;

commit;

create table user_table(
    user_idx number constraint user_pk primary key,
    user_name varchar2(50) not null,
    user_id varchar2(100) unique not null,
    user_pw varchar2(100) not null
    );
    
drop table user_table;

create table content_table(
    content_idx number constraint content_pk primary key,
    content_subject varchar2(500) not null,
    content_text long not null,
    content_file varchar2(500),
    content_writer_idx number not null constraint content_fk1 references user_table(user_idx),
    content_board_idx number not null constraint content_fk2 references board_info_table(board_info_idx),
    content_date date default sysdate
    );
    
    drop table content_table;

-- sequence

create sequence user_seq
    start with 0
    increment by 1
    minvalue 0;
    
create sequence content_seq
    start with 0
    increment by 1
    minvalue 0;

commit;

-- 문구
select * from board_info_table order by board_info_idx asc;
select * from user_table;
    