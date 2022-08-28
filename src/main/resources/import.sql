/*create users*/
INSERT INTO `users` (username, password, enabled) VALUES ('RostenRoss', '$2a$10$kNPId0pL/AXnJHqt/ChfReq2RHlBx2rQsn8ME3OG/cjWApmpWmeGC', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('RostenRossAdmin', '$2a$10$Dyx/LIs5FjBKU11pg3XG7uURB49s/1jnNJoVLv5efKFVd0FOcTRFe', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('EliPas', '$2a$10$kNPId0pL/AXnJHqt/ChfReq2RHlBx2rQsn8ME3OG/cjWApmpWmeGC', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('MaCristina', '$2a$10$kNPId0pL/AXnJHqt/ChfReq2RHlBx2rQsn8ME3OG/cjWApmpWmeGC', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('NestorCos', '$2a$10$kNPId0pL/AXnJHqt/ChfReq2RHlBx2rQsn8ME3OG/cjWApmpWmeGC', 1);
INSERT INTO `users` (username, password, enabled) VALUES ('PiliBe', '$2a$10$kNPId0pL/AXnJHqt/ChfReq2RHlBx2rQsn8ME3OG/cjWApmpWmeGC', 1);

/*create customers*/
INSERT INTO `customers` (user_id, name, lastname, create_at, email) VALUES (1,'Rosten', 'Ross', '2017-08-01','rosten_ross@gmail.com');
INSERT INTO `customers` (user_id, name, lastname,create_at, email) VALUES (2,'Rosten', 'Ross', '2017-08-01','rosten_ross@gmail.com');
INSERT INTO `customers` (user_id, name, lastname,create_at, email) VALUES (3,'Elias','Pascuet', '2017-08-01','elias_pascuet@gmail.com');
INSERT INTO `customers` (user_id, name, lastname,create_at, email) VALUES (4,'Maria Cristina','Roma', '2017-08-01','marica_roma@gmail.com');
INSERT INTO `customers` (user_id, name, lastname,create_at, email) VALUES (5,'Nestor Matias','Costantini', '2017-08-01','nestor_costantini@gmail.com');
INSERT INTO `customers` (user_id, name, lastname,create_at, email) VALUES (6,'Pilar','Benitez', '2017-08-01','pilar_benitez@gmail.com');

/*create roles*/
INSERT INTO `roles` (name) VALUES ('ROLE_USER');
INSERT INTO `roles` (name) VALUES ('ROLE_ADMIN');

/*create  useres_roles (only users) */
INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (6, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (3, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (4, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (5, 1);

/*create  useres_roles (only admin) */
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 1);

/*create posts*/

INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Muy rico todo.', '2017-08-01',1);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Excelente atencion.',  '2017-08-01',3)
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Me encanto la musica y la comida.',  '2017-08-01',4);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Lo lindo es la variedad en el menu Vegano.',  '2017-08-01',5);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Las pastas fueron lo mejor.',  '2017-08-01',6);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Viva la comida mexicana.', '2017-08-01',1);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('El servicio genial.',  '2017-08-01',4);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('Las bebidas muy sabrosas.',  '2017-08-01',6);
INSERT INTO `posts` (comment, create_at, customer_id) VALUES ('No hay mejor lugar', '2017-08-01',1);






/*INSER RESERVATIONS*/


INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date ) VALUES (1, 1, CURRENT_TIMESTAMP, '2022-09-5');
INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date ) VALUES (2, 1, CURRENT_TIMESTAMP, '2022-09-6');

INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date ) VALUES (2, 2, CURRENT_TIMESTAMP, '2022-09-5');
INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date ) VALUES (1, 2, CURRENT_TIMESTAMP, '2022-09-1');

INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date ) VALUES (6, 3, CURRENT_TIMESTAMP, '2022-09-5');
INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date ) VALUES (5, 3, CURRENT_TIMESTAMP, '2022-09-5');

INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date ) VALUES (5, 4, CURRENT_TIMESTAMP, '2022-08-29');
INSERT INTO `reservations` (restaurant_table_id, customer_id, create_at, reservation_date ) VALUES (6, 4, CURRENT_TIMESTAMP, '2022-08-29');