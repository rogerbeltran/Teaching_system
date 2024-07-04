package dto;

public class Teacher extends Person {
    private int yearsOfExperience;
    private String teacherCode;

    public Teacher(int age, String lastName, String name, int yearsOfExperience, String teacherCode) {
        super(name, lastName, age);
        this.yearsOfExperience = yearsOfExperience;
        this.teacherCode = teacherCode;
    }

    public void printTeacherProperties() {
        super.printpersonProperties();
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Teacher Code: " + teacherCode);
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }
}