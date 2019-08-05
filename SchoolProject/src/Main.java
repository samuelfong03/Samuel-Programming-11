import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* ---- VARIABLES ---- */
        Scanner scanner = new Scanner(System.in);
        Boolean quitProgram = false; // Toggled to true when user wants to exit the program

        String input1; // Used when storing multiple sets of data before plugging them into a class
        String input2; // Used when storing multiple sets of data before plugging them into a class

        School school = new School();

        /* ---- MESSAGES ---- */
        // Sets of preset messages that are printed later
        String header = "-------------------------------------";
        String welcomeString = "Welcome to the School Manager\nTo add a student enter 'addstudent'\nTo add a teacher enter 'addteacher'\nTo delete a student enter 'deletestudent'\nTo delete a teacher enter 'deleteteacher'\nTo list all students and/or teachers enter 'list'\nTo change the schools attributes enter 'edit'\nTo quit the program enter 'quit'";

        String addStudent1 = "You have selected: ADD STUDENT\nPlease enter the first name of the student";
        String addStudent2 = "Please enter last name of the student";
        String addStudent3 = "Please enter the students grade(1-12)";

        String addTeacher1 = "You have selected: ADD TEACHER\nPlease enter the first name of the teacher";
        String addTeacher2 = "Please enter the last name of the teacher";
        String addTeacher3 = "Please enter the course the teacher teaches";

        String deleteStudent = "You have selected: DELETE STUDENT\nPlease enter the id of the student you would like to remove";
        String deleteTeacher = "You have selected: DELETE TEACHER\nPlease enter the id of the teacher you would like to remove";

        String deleteConfirm = " will be removed from the system!";
        String addConfirm = " will be added to the system!";

        String listString = "You have selected: LIST\nTo list all students enter 'students'\nTo list all teachers enter 'teachers'\nTo list everything enter 'all'";
        String editString = "You have selected: EDIT\nTo change the school name enter 'name'\nTo change the amount of rooms in the school enter 'rooms'\nTo change the property size of the school enter 'size'";
        String quitString = "Thanks for using School Manager!\nSee you next time!";

        String changeNameString = "You have selected: CHANGE NAME\nPlease enter the new name";
        String nameChangeConfirmString = "You have changed the schools name to ";

        String changeRoomsString = "You have selected: CHANGE ROOMS\nPlease enter the number of rooms in the school";
        String roomChangeConfirmString = "You have changed the number of rooms to ";

        String sizeChangeString = "You have selected: CHANGE SIZE\nPlease enter the new new size if the school";
        String sizeChangeConfirm = "The new size of the school is ";

        String error1String = "Oops! Looks like you didn't enter a valid term.\nPlease try again";

        /* ---- RIN PROGRAM ---- */


        while(!quitProgram){
            // Print header and welcome string
            System.out.println(header + "\n" + welcomeString + "\n" + header);
            switch (scanner.next().toLowerCase()){
                case "addstudent":
                    System.out.println(addStudent1);
                    input1 = scanner.next();
                    System.out.println(addStudent2);
                    input2 = scanner.next();
                    System.out.println(addStudent3);
                    school.newStudent(input1, input2, Integer.parseInt(scanner.next()));
                    System.out.println(input1 + " " + input2 +  addConfirm);
                    break;
                case "addteacher":
                    System.out.println(addTeacher1);
                    input1 = scanner.next();
                    System.out.println(addTeacher2);
                    input2 = scanner.next();
                    System.out.println(addTeacher3);
                    school.newTeacher(input1, input2, scanner.next());
                    System.out.println(input1 + " " + input2 + addConfirm);
                    break;
                case "deletestudent":
                    System.out.println(deleteStudent);
                    printAll("students", school);
                    input1 = scanner.next();
                    System.out.println(school.students.get(Integer.parseInt(input1)) + deleteConfirm);
                    school.deleteStudent(Integer.parseInt(input1));
                    break;
                case "deleteteacher":
                    System.out.println(deleteTeacher);
                    printAll("teachers", school);
                    input1 = scanner.next();
                    System.out.println(school.teachers.get(Integer.parseInt(input1)) + deleteConfirm);
                    school.deleteTeacher(Integer.parseInt(input1));
                    break;
                case "list":
                    System.out.println(listString);
                    printAll(scanner.next(), school);
                    break;
                case "edit":
                    System.out.println(editString + "\n" + header);
                    if(scanner.next().toLowerCase().equals("name")){
                        System.out.println(changeNameString);
                        school.setSchoolName(scanner.next());
                        System.out.println(nameChangeConfirmString + school.getSchoolName());
                    }
                    else if(scanner.next().toLowerCase().equals("rooms")){
                        System.out.println(changeRoomsString);
                        school.setRoomCount(Integer.parseInt(scanner.next()));
                        System.out.println(roomChangeConfirmString + school.getRoomCount());
                    }
                    else if(scanner.next().toLowerCase().equals("size")){
                        System.out.println(sizeChangeString);
                        school.setSchoolArea(Integer.parseInt(scanner.next()));
                        System.out.println(sizeChangeConfirm + school.getSchoolArea() + " square feet");
                    }
                    break;
                case "quit":
                    System.out.println(quitString);
                    quitProgram = true;
                    break;
                default:
                    System.out.println(error1String);
                    break;
            }
        }
    }

    /* ---- METHODS ---- */
    static void printAll(String input, School school){
        /* ---- MESSAGES ---- */
        String studentHeader = "---------- STUDENTS ----------";
        String teacherHeader = "---------- TEACHERS ----------";
        String coursesHeader = "---------- OFFERED COURSES ----------";

        // Case detection
        if (input.toLowerCase().equals("students")) {
            System.out.println(studentHeader);
            if(school.students.size() > 0){
                for (int i = 0; i < school.students.size(); i++) {
                    System.out.println("Name: " + school.students.get(i).getFirstName() + " " + school.students.get(i).getLastName() + "\t\t\t\t\tGrade: " + school.students.get(i).getGrade() + "\t\tStudent ID: " + school.students.get(i).getStudentID());
                }
            }
        }
        else if (input.toLowerCase().equals("teachers")){
            System.out.println(teacherHeader);
            if(school.teachers.size() > 0){
                for(int i = 0; i < school.teachers.size(); i++){
                    System.out.println("Name: " + school.teachers.get(i).getFirstName() + " " + school.teachers.get(i).getLastName() + "\t\t\t\t\tTeacher ID: " + school.teachers.get(i).getTeacherID());
                }
            }
        }
        else if(input.toLowerCase().equals("all")){
            printAll("students", school);
            printAll("teachers", school);
        }
    }
}
