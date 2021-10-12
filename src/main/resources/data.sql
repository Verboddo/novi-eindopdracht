INSERT INTO users (username, password, enabled, age)
VALUES
    ('user', '$2a$12$M7lTa5EIkr6qBRh4SStqN.aho/uHPCijfqcs4FmYhxc9rojkSSd6.', TRUE, 27),
    ('admin', '$2a$12$M7lTa5EIkr6qBRh4SStqN.aho/uHPCijfqcs4FmYhxc9rojkSSd6.', TRUE, 17),
    ('ramon', '$2a$12$M7lTa5EIkr6qBRh4SStqN.aho/uHPCijfqcs4FmYhxc9rojkSSd6.', TRUE, 17);

INSERT INTO authorities (username, authority)
VALUES
    ('user', 'ROLE_USER'),
    ('admin', 'ROLE_USER'),
    ('admin', 'ROLE_ADMIN'),
    ('ramon', 'ROLE_USER'),
    ('ramon', 'ROLE_ADMIN');
