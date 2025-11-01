import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "your_password");
    }

    public void addStudent(Student s) throws SQLException {
        String query = "INSERT INTO Student VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, s.getStudentID());
            ps.setString(2, s.getName());
            ps.setString(3, s.getDepartment());
            ps.setDouble(4, s.getMarks());
            ps.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> list = new ArrayList<>();
        String query = "SELECT * FROM Student";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("StudentID"),
                        rs.getString("Name"),
                        rs.getString("Department"),
                        rs.getDouble("Marks"));
                list.add(s);
            }
        }
        return list;
    }

    public void updateStudent(Student s) throws SQLException {
        String query = "UPDATE Student SET Name=?, Department=?, Marks=? WHERE StudentID=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getDepartment());
            ps.setDouble(3, s.getMarks());
            ps.setInt(4, s.getStudentID());
            ps.executeUpdate();
        }
    }

    public void deleteStudent(int studentID) throws SQLException {
        String query = "DELETE FROM Student WHERE StudentID=?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, studentID);
            ps.executeUpdate();
        }
    }
}
