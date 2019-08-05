import java.util.ArrayList;

public class School {
    private String schoolName;
    private int roomCount;
    private double schoolArea;
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<String> courses = new ArrayList<>();

    School(){
        this.schoolName = "";
        this.roomCount = 0;

    }

    public void newStudent(String firstName, String lastName, int grade) {
        int finalGrade = grade;
        if(finalGrade > 12){
            finalGrade = 12;
        }
        else if(finalGrade < 1){
            finalGrade = 1;
        }
        students.add(new Student(firstName, lastName, finalGrade));
    }

    public void newTeacher(String firstName, String lastName, String subject){
        teachers.add(new Teacher(firstName, lastName, subject));
        courses.add(subject);
    }

    public void deleteStudent(int index){
        students.remove(index);
    }

    public void deleteTeacher(int index){
        teachers.remove(index);
        courses.remove(index);
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public double getSchoolArea() {
        return schoolArea;
    }

    public void setSchoolArea(double schoolArea) {
        this.schoolArea = schoolArea;
    }
}
