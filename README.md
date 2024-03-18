# StudentCRUDA3

This is a Maven project that does basic PostgreSQL queries. 

# JDK-17
Before running, ensure you have JDK-17 installed on your machine

# Setup 
1. Clone the repo locally
2. Inside src/main/java/StudentCRUD.java, modify the URL, USERNAME, and PASSWORD variables as needed
```
private static final String URL = "jdbc:postgresql://localhost:5432/AssignmentThree"; //Change AssignmentThree to the name of the database you have
private static final String USERNAME = "postgres";
private static final String PASSWORD = "admin";
```
4. Create the tables
```
CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    enrollment_date DATE
);
```
4. Insert data as needed
5. Using IntelliJ, Go to File > Open
6. Select the pom.xml, click OK.
7. In the dialog that opens, click Open as Project.
8. Run and build the src/main/java/Main.java (This should automatically download all dependencies)
9. Modify code Main.java as needed
