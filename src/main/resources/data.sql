INSERT INTO users (id_user, name, username, password) VALUES (default, 'Uno', 'admin@esto.es', '$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')
INSERT INTO users (id_user, name, username, password) VALUES (default, 'Dos', 'nada01@esto.es', '$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')
INSERT INTO users (id_user, name, username, password) VALUES (default, 'Tres', 'nada02@esto.es', '$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')
INSERT INTO users (id_user, name, username, password) VALUES (default, 'Cuatro', 'user@esto.es' ,'$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')

INSERT INTO roles (id_role, role) VALUES (default, "ROLE_ADMIN")
INSERT INTO roles (id_role, role) VALUES (default, "ROLE_USER")

INSERT INTO courses (id_course, course, description) VALUES (default, "HTML", "Ipsum dolor sit amet, consectetur adipiscing elit. Curabitur at hendrerit metus. Phasellus vitae augue laoreet, rhoncus eros a, maximus ipsum. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
INSERT INTO courses (id_course, course, description) VALUES (default, "CSS", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur at hendrerit metus. Phasellus vitae augue laoreet, rhoncus eros a, maximus ipsum. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
INSERT INTO courses (id_course, course, description) VALUES (default, "JavScript", "Dolor sit amet, consectetur adipiscing elit. Curabitur at hendrerit metus. Phasellus vitae augue laoreet, rhoncus eros a, maximus ipsum. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
INSERT INTO courses (id_course, course, description) VALUES (default, "Vue", "Sit amet, consectetur adipiscing elit. Curabitur at hendrerit metus. Phasellus vitae augue laoreet, rhoncus eros a, maximus ipsum. Lorem ipsum dolor sit amet, consectetur adipiscing elit.")

INSERT INTO roles_users (user_id, role_id) VALUES (1, 1)
INSERT INTO roles_users (user_id, role_id) VALUES (3, 2)
INSERT INTO roles_users (user_id, role_id) VALUES (4, 2)

INSERT INTO courses_users (user_id, course_id) VALUES (1, 1)
INSERT INTO courses_users (user_id, course_id) VALUES (1, 2)
INSERT INTO courses_users (user_id, course_id) VALUES (1, 3)
INSERT INTO courses_users (user_id, course_id) VALUES (1, 4)
INSERT INTO courses_users (user_id, course_id) VALUES (2, 1)
INSERT INTO courses_users (user_id, course_id) VALUES (3, 1)
INSERT INTO courses_users (user_id, course_id) VALUES (3, 2)

INSERT INTO shoppingcartitems (id_shoppingcartitem, id_user, id_course) VALUES (default, 2, 2)