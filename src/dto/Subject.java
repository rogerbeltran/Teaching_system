package dto;

import java.util.List;

public class Subject {
    private String name;
    private Teacher teacher;
    private List<Student> studentList;

    public Subject(String name, Teacher teacher, List<Student> studentList) {
        this.name = name;
        this.teacher = teacher;
        this.studentList = studentList;
    }
    public void printsubjectProperties(){
        System.out.println("Subject Name: " + name);
        System.out.println("Teacher's Name: " + teacher);
        System.out.println("Student's list: " + studentList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}