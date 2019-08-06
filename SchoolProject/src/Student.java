public class Student {
    /* ---- VARIABLES ---- */
    private String firstName;
    private String lastName;
    private int grade;
    static int sidNumber = 0;
    private int studentID;

    /* ---- STUDENT CONSTRUCTOR ---- */
    Student(String first, String last, int grade){ // Student takes in a first name last name and grade
        this.firstName = first; // Sets this students first name to the input first name
        this.lastName = last; // Sets this students last name to the input last name
        this.grade = grade; // Sets this students grade to the input students grade
        this.studentID = sidNumber; // Sets this students id number to the current id number value
        sidNumber++; // Increase the current students id number upt by one
    }

    /* ---- GETTERS AND SETTERS ---- */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
