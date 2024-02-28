CREATE TABLE IF NOT EXISTS Employee(
    id UUID PRIMARY KEY,
    name VARCHAR (255),
    hired BOOLEAN
);

-- Create Salary table
CREATE TABLE IF NOT EXISTS Salary(
    id UUID PRIMARY KEY,
    employee_id UUID,
    amount DOUBLE,
    issue_date TIMESTAMP,
    FOREIGN KEY(employee_id) REFERENCES Employee(id)
);