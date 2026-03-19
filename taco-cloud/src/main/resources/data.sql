delete from TACO_ORDER;
delete from TACO;
delete from TACO_INGREDIENT;
delete from INGREDIENT;

insert into INGREDIENT (id, name, type) values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into INGREDIENT (id, name, type) values ('COTO', 'Corn Tortilla', 'WRAP');
insert into INGREDIENT (id, name, type) values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into INGREDIENT (id, name, type) values ('CARN', 'Carnitas', 'PROTEIN');
insert into INGREDIENT (id, name, type) values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into INGREDIENT (id, name, type) values ('LETC', 'Lettuce', 'VEGGIES');
insert into INGREDIENT (id, name, type) values ('CHED', 'Cheddar', 'CHEESE');
insert into INGREDIENT (id, name, type) values ('JACK', 'Monterey Jack', 'CHEESE');
insert into INGREDIENT (id, name, type) values ('SLSA', 'Salsa', 'SAUCE');
insert into INGREDIENT (id, name, type) values ('SRCR', 'Sour   Cream', 'SAUCE');
