create table if not exists TACO_ORDER (
    id bigint primary key auto_increment,
    delivery_name varchar(255),
    delivery_street varchar(255),
    delivery_city varchar(255),
    delivery_state varchar(255),
    delivery_zip varchar(255),
    cc_number varchar(255),
    cc_expiration varchar(255),
    cc_cvv varchar(255),
    placed_at timestamp not null
);

create table if not exists TACO (
    id bigint primary key auto_increment,
    name varchar(255),
    order_id bigint not null,
    sequence bigint not null,
    created_at timestamp not null
);

create table if not exists TACO_INGREDIENT(
    taco_id bigint not null,
    sequence bigint not null,
    ingredient_id varchar(4) not null
);

create table if not exists INGREDIENT (
    id varchar(4) primary key,
    name varchar(255),
    type varchar(255)
);

create table if not exists APP_USER (
    id bigint primary key auto_increment,
    username varchar(255) not null unique,
    password varchar(255) not null,
    fullname varchar(255) not null,
    street varchar(255) not null,
    city varchar(255) not null,
    state varchar(255) not null,
    zip varchar(255) not null,
    phonenumber varchar(255) not null
);