# Intro

**Change Data Capture (CDC)** is a technique or process used in data management systems to identify and track changes made to data in a database, and then propagate those changes to other systems or data stores. It is widely used in scenarios where real-time or near real-time data synchronization, replication, or analysis is required.

# References

https://www.baeldung.com/debezium-intro

# Run

```sh
docker-compose up -d
./mvnw spring-boot:run
```

How to connect to MySQL:  

```sh
docker exec -it source-database /bin/bash
mysql --user=user1 --password customerdb1
Enter password:
Welcome to the MySQL monitor.
...
show tables;
```

# Test

- Create `customer` table in source DB.
- INS/UPD/DEL some data and see the replication

```sql
CREATE TABLE customer
(
    id integer NOT NULL,
    fullname character varying(255),
    email character varying(255),
    CONSTRAINT customer_pkey PRIMARY KEY (id)
);

INSERT INTO customer (id, fullname, email) VALUES
(1, 'john', 'n1@email.com'),	
(2, 'mike', 'n2@email.com'),	
(3, 'paul', 'n3@email.com');

update customer set fullname = 'maria' where id = 3;
delete from customer where id = 2;
```