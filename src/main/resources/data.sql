INSERT INTO users (id_user, name, username, password) VALUES (default, 'Uno', 'admin@.es', '$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')
INSERT INTO users (id_user, name, username, password) VALUES (default, 'Dos', 'nada01@.es', '$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')
INSERT INTO users (id_user, name, username, password) VALUES (default, 'Tres', 'nada02@.es', '$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')
INSERT INTO users (id_user, name, username, password) VALUES (default, 'Cuatro', 'user@.es' ,'$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')

INSERT INTO roles (id_role, role) VALUES (default, "ROLE_ADMIN")
INSERT INTO roles (id_role, role) VALUES (default, "ROLE_USER")

INSERT INTO roles_users (user_id, role_id) VALUES (1, 1)
INSERT INTO roles_users (user_id, role_id) VALUES (3, 2)
INSERT INTO roles_users (user_id, role_id) VALUES (4, 2)