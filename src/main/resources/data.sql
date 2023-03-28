INSERT INTO users (id_user, username, password) VALUES (default, 'admin@.es', '$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')
INSERT INTO users (id_user, username, password) VALUES (default, 'nada01@.es', '$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')
INSERT INTO users (id_user, username, password) VALUES (default, 'nada02@.es', '$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')
INSERT INTO users (id_user, username, password) VALUES (default, 'user@.es' ,'$2a$10$6wDeb3wqewh/nSWKVyIh5.0D4XjqyktJ5afuca0aBXDo1sUUIPDAO')

INSERT INTO roles (id_role, role) VALUES (default, "ROLE_ADMIN")
INSERT INTO roles (id_role, role) VALUES (default, "ROLE_USER")

INSERT INTO roles_users (user_id, role_id) VALUES (1, 1)
INSERT INTO roles_users (user_id, role_id) VALUES (4, 2)