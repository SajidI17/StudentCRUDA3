# StudentCRUDA3

This is a Maven project that does basic PostgreSQL queries. 

# Pre-req Software
- Before running, ensure you have JDK-17 installed on your machine

# Setup 
1. Clone the repo locally
2. Create a database called "AssignmentThree" PostgreSQL (or modify the URL in StudentCRUD.java with a name of your choosing)

3. Create the tables
```
CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    enrollment_date DATE
);
```
4. Insert data into the students table
```
INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');
```
5. Using IntelliJ, Go to File > Open
6. Select the pom.xml, click OK.
7. In the dialog that opens, click Open as Project.
8. Inside src/main/java/StudentCRUD.java, modify the URL, USERNAME, and PASSWORD variables as needed
```
private static final String URL = "jdbc:postgresql://localhost:5432/AssignmentThree"; //Change AssignmentThree to the name of the database you have
private static final String USERNAME = "postgres";
private static final String PASSWORD = "admin";
```
9. Modify the main function as needed
9. Build and run the src/main/java/StudentCRUD.java inside IntelliJ

# Video Demo (OneDrive Link Share)
https://1drv.ms/v/s!Atmy6GAj6fAchtdmY7p0O5VOibeksQ?e=EIbgaF

