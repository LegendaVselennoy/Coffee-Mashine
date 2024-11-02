create table if not exists "test-engineer".drinks
(
    id bigserial primary key ,
    type varchar(20),
    popular integer default 0
);

create table if not exists "test-engineer".ingredients
(
    id bigserial primary key ,
    name varchar(20),
    quantity integer
);

create table "test-engineer".drinks_ingredients
(
    drinks_id bigint references drinks(id),
    ingredients_id bigint references ingredients(id),
    primary key (drinks_id,ingredients_id)
);