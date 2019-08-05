public class Student {
    private String firstName;
    private String lastName;
    private int grade;
    static int sidNumber = 0;
    private int studentID;

    Student(String first, String last, int grade){
        this.firstName = first;
        this.lastName = last;
        this.grade = grade;
        this.studentID = sidNumber;
        sidNumber++;
    }

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
