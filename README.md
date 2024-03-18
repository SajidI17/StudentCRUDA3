# StudentCRUDA3

This is a Maven project that does basic PostgreSQL queries. 

# JDK-17
Before running, ensure you have JDK-17 installed on your machine

# Setup 
1. Clone the repo
2. Inside src/main/java/StudentCRUD.java, modify the URL, USERNAME, and PASSWORD variables as needed
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
4. Insert data as needed
5. Using IntelliJ, Go to File > Open
6. Select the pom.xml, click OK.
7. In the dialog that opens, click Open as Project.
8. Run and build the src/main/java/Main.java
9. Modify code Main.java as needed



