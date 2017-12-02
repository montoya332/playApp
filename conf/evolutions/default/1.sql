# Users schema

# --- !Ups


CREATE TABLE users (
    id              varchar PRIMARY KEY CONSTRAINT no_null NOT NULL,
    email           varchar NOT NULL,
    password        varchar CONSTRAINT no_null NOT NULL,
    fullname        varchar CONSTRAINT no_null NOT NULL,
    isAdmin boolean NOT NULL,
    created         TIMESTAMP CONSTRAINT no_null NOT NULL DEFAULT now(),
    archived        TIMESTAMP
);

# --- !Downs

DROP TABLE users;
