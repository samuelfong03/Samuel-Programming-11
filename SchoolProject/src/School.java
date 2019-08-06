import java.util.ArrayList;

public class School {
    /* ---- VARIABLES ---- */ // (You asked for 3 fields so i chose these 3)
    private String schoolName;
    private int roomCount;
    private int schoolArea;

    /* ---- ARRAY LISTS ---- */
    ArrayList<Teacher> teachers = new ArrayList<>(); // Array list of teachers called teachers
    ArrayList<Student> students = new ArrayList<>(); // Array list of students called students
    ArrayList<String> courses = new ArrayList<>(); // Array list of strings called courses

    /* ---- SCHOOL CONSTRUCTOR ---- */
    School(){ // Does not take anything in defaults values of the school
        this.schoolName = ""; // Default name
        this.roomCount = 0; // Default room count
        this.schoolArea = 0; // Default school size
    }

    /* ---- METHODS ---- */
    public void newStudent(String firstName, String lastName, int grade) { // New student takes in a first name last name and grade
        int finalGrade = grade; // Creates a finalgrade variable to be rounded between 1 and 12
        if(finalGrade > 12){ // If the final grade is larger than 12
            finalGrade = 12; // Set it to 12
        }
        else if(finalGrade < 1){ // If the final grade is less than 1
            finalGrade = 1; // Set it to 1
        }
        students.add(new Student(firstName, lastName, finalGrade)); // Create a new student in the array list using all the input values
    }

    public void newTeacher(String firstName, String lastName, String subject){ // New teacher takes in a first name last name and subject
        teachers.add(new Teacher(firstName, lastName, subject)); // Create a new teacher in the array list with the input values
        courses.add(subject); // Add the subject to the courses list
    }

    public void deleteStudent(int index){ // Delete student takes in the index of the student you want to delete
        students.remove(index); // Remove the student from the input index
    }

    public void deleteTeacher(int index){ // Delete teachers takes in the index of the teacher you want to remove
        teachers.remove(index); // Remove the teacher from the input index
        courses.remove(index); // Remove the course the teacher taught from course
    }

    /* ---- GETTERS AND SETTERS ---- */
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

    public int getSchoolArea() {
        return schoolArea;
    }

    public void setSchoolArea(int schoolArea) {
        this.schoolArea = schoolArea;
    }
}
