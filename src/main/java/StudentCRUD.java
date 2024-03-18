import java.sql.*;

public class StudentCRUD {
    private static final String URL = "jdbc:postgresql://localhost:5432/AssignmentThree"; //Change AssignmentThree to the name of the database you have
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("BEFORE INSERT");
        System.out.println("===============================================");
        getAllStudents();

        System.out.println("\n");
        addStudent("Sajid", "Islam", "sajid.islam@example.com", Date.valueOf("2023-09-03"));
        System.out.println("===============================================");
        System.out.println("AFTER INSERT");
        System.out.println("===============================================");
        getAllStudents();

        System.out.println("\n");
        updateStudentEmail(5,"random12233@example.com");
        System.out.println("===============================================");
        System.out.println("AFTER UPDATE");
        System.out.println("===============================================");
        getAllStudents();

        System.out.println("\n");
        deleteStudent(5);
        System.out.println("===============================================");
        System.out.println("AFTER DELETE");
        System.out.println("===============================================");
        getAllStudents();

        //addStudent("Sajid", "Islam", "sajid.islam@example.com", Date.valueOf("2023-09-03"));
        //updateStudentEmail(4,"random12233@example.com");
        //deleteStudent(4);
        //getAllStudents();
    }

    //Gets all students from the table and prints it to console
    public static void getAllStudents() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            //Create the statement
            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM students");
            ResultSet resultSet = statement.getResultSet();

            //Print all results
            while (resultSet.next()) {
                System.out.println("Student ID: " + resultSet.getInt("student_id"));
                System.out.println("\tFirst Name: " + resultSet.getString("first_name"));
                System.out.println("\tLast Name: " + resultSet.getString("last_name"));
                System.out.println("\tEmail: " + resultSet.getString("email"));
                System.out.println("\tEnrollment Date: " + resultSet.getDate("enrollment_date"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Assuming function will be provided the java.sql.date object
    //Adds a student given firstname, lastname, email and enrollmentDate
    public static void addStudent(String firstName, String lastName, String email, Date enrollmentDate) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";

            //prepare statement
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setDate(4, enrollmentDate);

            preparedStatement.executeUpdate();
            System.out.println("Data Inserted Successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //will update a students email given their id
    public static void updateStudentEmail(int studentId, String newEmail) {
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String updateSQL = "UPDATE students SET email = ? WHERE student_id = ?";

            //prepare statement
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, studentId);

            preparedStatement.executeUpdate();
            System.out.println("Data Updated Successfully");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    //deletes a student from the table given their id
    public static void deleteStudent(int student_id){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String deleteSQL = "DELETE FROM students WHERE student_id = ?";

            //prepare statement
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, student_id);

            preparedStatement.executeUpdate();
            System.out.println("Data Deleted Successfully");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
