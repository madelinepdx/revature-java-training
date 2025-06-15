CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    post VARCHAR(255),
    user_fk int REFERENCES site_user(id)
);