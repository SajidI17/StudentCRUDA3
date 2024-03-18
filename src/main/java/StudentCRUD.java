import java.sql.*;

public class StudentCRUD {
    private static final String URL = "jdbc:postgresql://localhost:5432/AssignmentThree";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    public void getAllStudents() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();
            statement.executeQuery("SELECT * FROM students");
            ResultSet resultSet = statement.getResultSet();

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
    public void addStudent(String firstName, String lastName, String email, Date enrollmentDate) {
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

    public void updateStudentEmail(int studentId, String newEmail) {
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String updateSQL = "UPDATE students SET email = ? WHERE student_id = ?";

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
    public void deleteStudent(int student_id){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String deleteSQL = "DELETE FROM students WHERE student_id = ?";

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
