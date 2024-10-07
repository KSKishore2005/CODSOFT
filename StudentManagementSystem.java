import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    char grade;

    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(String name, int rollNumber, char grade) {
        students.add(new Student(name, rollNumber, grade));
        System.out.println("Student added successfully.");
    }

    public static void displayStudents() {
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println("Name: " + student.name + ", Roll Number: " + student.rollNumber + ", Grade: " + student.grade);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    char grade = scanner.next().charAt(0);
                    addStudent(name, rollNumber, grade);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}
