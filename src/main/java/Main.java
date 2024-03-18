public class Main {
    public static void main(String[] args) {

        StudentCRUD studentCRUD = new StudentCRUD();
        //studentCRUD.updateStudentEmail(2,"random@example.com");
        studentCRUD.deleteStudent(4);

        studentCRUD.getAllStudents();

        //studentCRUD.addStudent("Sajid", "Islam", "sajid.islam@example.com", Date.valueOf("2023-09-03"));
    }
}