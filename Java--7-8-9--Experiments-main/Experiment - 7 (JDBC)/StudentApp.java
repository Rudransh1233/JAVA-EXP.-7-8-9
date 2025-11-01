import java.util.*;

public class StudentApp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StudentDAO dao = new StudentDAO();
            boolean exit = false;

            while (!exit) {
                System.out.println("\n1. Add Student\n2. View All\n3. Update\n4. Delete\n5. Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Marks: ");
                        double marks = sc.nextDouble();
                        dao.addStudent(new Student(id, name, dept, marks));
                        System.out.println("Student added.");
                    }
                    case 2 -> {
                        List<Student> students = dao.getAllStudents();
                        students.forEach(s -> System.out.printf("%d %s %s %.2f%n",
                                s.getStudentID(), s.getName(), s.getDepartment(), s.getMarks()));
                    }
                    case 3 -> {
                        System.out.print("Enter ID to update: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("New Name: ");
                        String name = sc.nextLine();
                        System.out.print("New Department: ");
                        String dept = sc.nextLine();
                        System.out.print("New Marks: ");
                        double marks = sc.nextDouble();
                        dao.updateStudent(new Student(id, name, dept, marks));
                        System.out.println("Updated.");
                    }
                    case 4 -> {
                        System.out.print("Enter ID to delete: ");
                        int id = sc.nextInt();
                        dao.deleteStudent(id);
                        System.out.println("Deleted.");
                    }
                    case 5 -> exit = true;
                    default -> System.out.println("Invalid choice.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
