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
            System.out.println("4. Print Students ");
            System.out.println("5. Print Teachers ");
            System.out.println("6. Print Subjects ");
            System.out.println("7. Exit ");

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
                    System.out.println("***** Printing Students *******");
                    printStudents(studentList);
                    break;
                case 5:
                    System.out.println("***** Printing Teachers *******");
                    printTeachers(teacherList);
                    break;
                case 6:
                    System.out.println("***** Printing Subjects *******");
                    printSubjects(subjectList);
                    break;
                case 7:
                    System.out.println("***** Exit System *******");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while(option != 7);
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
        return new Student(name, lastName, age, studentCode, noOfSemester);
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
        return new Teacher(name, lastName, age, teacherCode, yearsOfExperience);
    }

    public static void printTeachers(List<Teacher> teacherList) {
        int index = 1;
        for(Teacher teacher : teacherList) {
            System.out.println(index + ". " + teacher.getName() + " " + teacher.getLastName()
                    + " - Teacher Code: " + teacher.getTeacherCode()
                    + ", Years of Experience: " + teacher.getYearsOfExperience());
            index++;
        }
    }

    public static void printStudents(List<Student> studentList) {
        int index = 1;
        for(Student student : studentList) {
            System.out.println(index + ". " + student.getName() + " " + student.getLastName()
                    + " - Student Code: " + student.getStudentCode()
                    + ", Number of Semesters: " + student.getNoOfSemester());
            index++;
        }
    }

    public static void printSubjects(List<Subject> subjectList) {
        int index = 1;
        for(Subject subject : subjectList) {
            System.out.println(index + ". " + subject.getName()
                    + " - Teacher: " + subject.getTeacher().getName() + " " + subject.getTeacher().getLastName()
                    + ", Students Enrolled: " + subject.getStudentList().size());
            index++;
        }
    }

    public static Subject createSubject(List<Teacher> teacherList, List<Student> studentList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a name: ");
        String name = scanner.next();

        System.out.println("Please select a teacher: ");
        printTeachers(teacherList);
        int teacherOption = scanner.nextInt();
        Teacher teacher = teacherList.get(teacherOption - 1);

        List<Student> students = new ArrayList<>();
        System.out.println("Please enter the number of Students to register: ");
        int noOfStudents = scanner.nextInt();

        for(int n = 0; n < noOfStudents; n++) {
            System.out.println("Please select a student: ");
            printStudents(studentList);
            int studentOption = scanner.nextInt();
            Student student = studentList.get(studentOption - 1);
            students.add(student);
        }

        return new Subject(name, teacher, students);
    }
}