CREATE TABLE subordination
(
    Id SERIAL PRIMARY KEY,
    Manager_id INTEGER REFERENCES employee (Id),
    Worker_id INTEGER REFERENCES employee (Id)
);