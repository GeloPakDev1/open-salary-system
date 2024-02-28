-- Insert sample employee data
INSERT INTO Employee (id, name, hired)
VALUES (UUID(), 'John Doe', TRUE),
       (UUID(), 'Jane Smith', TRUE),
       (UUID(), 'Alice Johnson', FALSE),
       (UUID(), 'Bob Williams', TRUE),
       (UUID(), 'Eva Brown', FALSE);
-- Insert sample salary data
-- For simplicity, let's assume each employee has one salary entry
INSERT INTO Salary (id, employee_id, amount, issue_date)
SELECT UUID(),
       (SELECT id FROM Employee WHERE name = 'John Doe'),
       ROUND(RAND() * (65000.0 - 50000.0) + 50000.0, 2),
       CURRENT_TIMESTAMP
FROM (SELECT n1
      FROM (SELECT 1 n1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5) t1,
           (SELECT 1 n2 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5) t2,
           (SELECT 1 n3 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5) t3) nums LIMIT 50;

