import java.sql.*;

public class EmployeeFetcher {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "your_password"; // replace with your MySQL password

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Employee")) {

            System.out.println("EmpID\tName\t\tSalary");
            System.out.println("-----------------------------");
            while (rs.next()) {
                int id = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                System.out.printf("%d\t%-10s\t%.2f%n", id, name, salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
