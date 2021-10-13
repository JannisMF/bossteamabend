DROP TABLE if EXISTS tbl_player;
CREATE TABLE tbl_player
(
    id     INT NOT NULL,
    health INT NOT NULL,
    food   INT NOT NULL,
    armor  INT NOT NULL,
    PRIMARY KEY (id)
);