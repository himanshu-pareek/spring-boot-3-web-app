CREATE TABLE IF NOT EXISTS orders (
    id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR (20) NOT NULL,
    placed_time TIMESTAMP NOT NULL,
    total_amount INT NOT NULL,
    status VARCHAR(15) DEFAULT 'CREATED'
);
