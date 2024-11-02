insert into "test-engineer".drinks(id, type,popular)
values (1, 'Expresso', 0),
       (2, 'Americano', 0),
       (3, 'Cappuccino', 0);

insert into "test-engineer".ingredients(id, name, quantity)
values (1,'Вода', 100),
       (2, 'Таурин', 15),
       (3, 'Фруктоза', 17),
       (4, 'Кофеин', 18),
       (5, 'Зёрна', 50),
       (6, 'Сахар', 90),
       (7, 'Сливки', 30);

insert into "test-engineer".drinks_ingredients(drinks_id, ingredients_id)
values (1,1),
       (1,5),
       (1,6),
       (2,1),
       (2,4),
       (2,5),
       (3,1),
       (3,5),
       (3,7);