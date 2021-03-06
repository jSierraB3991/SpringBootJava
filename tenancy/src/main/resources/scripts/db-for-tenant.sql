CREATE TABLE if not exists public.DATASOURCECONFIG (
   id bigint PRIMARY KEY,
   driverclassname VARCHAR(255),
   url VARCHAR(255),
   name VARCHAR(255),
   username VARCHAR(255),
   password VARCHAR(255),
   initialize BOOLEAN
);
INSERT INTO DATASOURCECONFIG 
VALUES 
	(1, 
	'org.postgresql.Driver', 
	'jdbc:postgresql://localhost:5433/tenant1?ApplicationName=MultiTenant', 
	'tenant1', 
	'postgres', 
	'root', 
	true);
	
INSERT INTO DATASOURCECONFIG 
VALUES (2, 
		'org.postgresql.Driver',
		'jdbc:postgresql://localhost:5433/tenant2?ApplicationName=MultiTenant',
		'tenant2',
		'postgres',
		'root',
		true);