import dto.Student;
import dto.Subject;
import dto.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        Scanner sc = new Scanner(System.in);
        List<Teacher> teacherList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        List<Subject> subjectList = new ArrayList<>();
        do {
            System.out.println("---------- Teaching System ------------");
            System.out.println("1. Create a Student ");
            System.out.println("2. Create a Teacher ");
            System.out.println("3. Create a Subject ");
            System.out.println("4. Print Student List ");
            System.out.println("5. Print Teacher List ");
            System.out.println("6. Exit ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    Student student = createStudent();
                    studentList.add(student);
                    break;
                case 2:
                    Teacher teacher = createTeacher();
                    teacherList.add(teacher);
                    break;
                case 3:
                    Subject subject = createSubject(teacherList, studentList);
                    subjectList.add(subject);
                    break;
                case 4:
                    printStudentList(studentList);
                    break;
                case 5:
                    printTeacherList(teacherList);
                    break;
                case 6:
                    System.out.println("***** Exit System *******");
                    break;
            }
        } while (option != 6);
    }

    public static Student createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a name: ");
        String name = scanner.next();
        System.out.println("Please enter a LastName: ");
        String lastName = scanner.next();
        System.out.println("Please enter age:");
        int age = scanner.nextInt();
        System.out.println("Please enter studentCode:");
        String studentCode = scanner.next();
        System.out.println("Please enter number of semester:");
        int noOfSemester = scanner.nextInt();
        return new Student(noOfSemester, name, lastName, age, studentCode);
    }

    public static Teacher createTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a name: ");
        String name = scanner.next();
        System.out.println("Please enter a LastName: ");
        String lastName = scanner.next();
        System.out.println("Please enter age:");
        int age = scanner.nextInt();
        System.out.println("Please enter teacherCode:");
        String teacherCode = scanner.next();
        System.out.println("Please enter years of Experience:");
        int yearsOfExperience = scanner.nextInt();
        return new Teacher(yearsOfExperience, name, lastName, age, teacherCode);
    }

    public static void printTeacherList(List<Teacher> teacherList) {
        int index = 1;
        for (Teacher teacher : teacherList) {
            System.out.println(index + " . " + teacher.getName().toUpperCase()
                    + " - " + teacher.getLastName().toUpperCase());
            index = index + 1;
        }
    }

    public static void printStudentList(List<Student> studentList) {
        int index = 1;
        for (Student student : studentList) {
            System.out.println(index + " . " + student.getName().toUpperCase()
                    + " - " + student.getLastName().toUpperCase());
            index = index + 1;
        }
    }

    public static Subject createSubject(List<Teacher> teacherList, List<Student> studentList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a name: ");
        String name = scanner.next();

        System.out.println("Please select a teacher: ");
        printTeacherList(teacherList);
        int teacherOption = scanner.nextInt();
        Teacher teacher = teacherList.get(teacherOption - 1);

        List<Student> students = new ArrayList<>();
        System.out.println("Please enter the no. of Students to register: ");
        int noOfStudent = scanner.nextInt();

        for (int n = 0; n < noOfStudent; n++) {
            System.out.println("Please select a student: ");
            printStudentList(studentList);
            int studentOption = scanner.nextInt();
            Student student = studentList.get(studentOption - 1);
            students.add(student);
        }

        return new Subject(name, teacher, students);
    }
}
