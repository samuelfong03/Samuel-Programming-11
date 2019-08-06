public class Teacher {
    /* ---- VARIABLES ---- */
    private String firstName;
    private String lastName;
    private String subject;
    static int tidNumber = 0;
    private int teacherID;

    /* ---- TEACHER CONSTRUCTOR ---- */
    Teacher(String firstName, String lastName, String subject){ // Takes in a first name, last name and subject
        this.firstName = firstName; // Sets this teachers first name to input first name
        this.lastName = lastName; // Sets this teachers last name to input last name
        this.subject = subject; // Sets this subject to the input subject
        this.teacherID = tidNumber; // Sets this teachers idnumber to the idnumber
        tidNumber++; // Add one to the id number so that you don't get repeat numbers
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }
}
