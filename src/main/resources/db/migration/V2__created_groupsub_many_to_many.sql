
ALTER TABLE tg_user ADD PRIMARY KEY (chat_id);

DROP TABLE IF EXISTS group_sub;
DROP TABLE IF EXISTS group_x_user;

CREATE TABLE group_sub (
   id INT,
   title VARCHAR(100),
   last_article_id INT,
   PRIMARY KEY (id)
);

CREATE TABLE group_x_user (
   group_sub_id INT NOT NULL,
   user_id INT NOT NULL,
   FOREIGN KEY (user_id) REFERENCES tg_user(chat_id),
   FOREIGN KEY (group_sub_id) REFERENCES group_sub(id),
   UNIQUE(user_id, group_sub_id)
);
