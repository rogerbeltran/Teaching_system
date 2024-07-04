package dto;

public class Student extends Person {
    private int noOfSemester;
    private String studentCode;

    public Student(int age, String lastName, String name, int noOfSemester, String studentCode) {
        super(name, lastName, age);
        this.noOfSemester = noOfSemester;
        this.studentCode = studentCode;
    }

    public void printStudentProperties() {
        super.printpersonProperties();
        System.out.println("Number of Semesters: " + noOfSemester);
        System.out.println("Student Code: " + studentCode);
    }

    public int getNoOfSemester() {
        return noOfSemester;
    }

    public void setNoOfSemester(int noOfSemester) {
        this.noOfSemester = noOfSemester;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
}