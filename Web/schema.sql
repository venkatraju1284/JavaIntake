create table author_information (
       author_id bigint not null,
        author varchar(255),
        primary key (author_id)
    );

create table tedtalk_information (
       id bigint not null,
        author varchar(255),
        author_interaction_date timestamp,
        likes bigint,
        views bigint,
        title varchar(255),
        url_information varchar(255),
        primary key (id)
    );

create sequence author_id start with 1 increment by 1;
create sequence hibernate_sequence start with 1 increment by 1;

--alter table tedtalk_information
--       add constraint FKtik0y8eja6jhbqjo5jebqdahl
--       foreign key (author_id)
--       references author_information;
