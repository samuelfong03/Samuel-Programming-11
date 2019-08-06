import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* ---- VARIABLES ---- */
        Scanner scanner = new Scanner(System.in); // Define the scanner for use
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
        while(!quitProgram){ // While loop for the program. While quitProgram is false program will run
            System.out.println(header + "\n" + welcomeString + "\n" + header); // Print header and welcome string
            switch (scanner.next().toLowerCase()){ // Switch case detecting the users input
                case "addstudent": // Case for addstudents
                    System.out.println(addStudent1); // Print preset message (first name prompt)
                    input1 = scanner.next(); // Detect scanner input and store it in a variable
                    System.out.println(addStudent2); // Print preset message (last name prompt)
                    input2 = scanner.next(); // Store input in a preset variable
                    System.out.println(addStudent3); // Print preset message (grade prompt)
                    school.newStudent(input1, input2, Integer.parseInt(scanner.next())); // Access functions from the school and run the create student function plugging in all inputs to create a new student
                    System.out.println(input1 + " " + input2 +  addConfirm); // Print a preset message to confirm creation of student
                    break;
                case "addteacher": // Case for addteacher
                    System.out.println(addTeacher1); // Print preset message (first name prompt)
                    input1 = scanner.next(); // Store user input in a variable
                    System.out.println(addTeacher2); // Print preset message (last name prompt)
                    input2 = scanner.next(); // Store users input in a variable
                    System.out.println(addTeacher3); // Print preset message (class taught prompt)
                    school.newTeacher(input1, input2, scanner.next()); // Access school class to run newTeacher function to create a new teacher by plugging in users inputs
                    System.out.println(input1 + " " + input2 + addConfirm); // Print preset message to confirm teachers creation
                    break;
                case "deletestudent": // Case for deletestudent
                    System.out.println(deleteStudent); // Print preset message (index prompt)
                    printAll("students", school); // Run printall function to list all students for the user to know what to delete
                    input1 = scanner.next(); // Get user input and store in a variable
                    System.out.println(school.students.get(Integer.parseInt(input1)) + deleteConfirm); // Print preset message confirming removal of that index
                    school.deleteStudent(Integer.parseInt(input1)); // Access the school class and run the  deletestudent function
                    break;
                case "deleteteacher": // Case for delete teacher
                    System.out.println(deleteTeacher); // Print preset message for deleteteacher
                    printAll("teachers", school); // Run printall function so user knows what index to delete
                    input1 = scanner.next(); // Get user input and save in variable
                    System.out.println(school.teachers.get(Integer.parseInt(input1)) + deleteConfirm); // Print preset message confirming removal of teacher
                    school.deleteTeacher(Integer.parseInt(input1)); // Access the school class and run the  deleteteacher function
                    break;
                case "list": // Case for list
                    System.out.println(listString); // Print preset message prompting user for input
                    printAll(scanner.next(), school); // Run printall using the users input and the school class
                    break;
                case "edit": // Case for edit
                    System.out.println(editString + "\n" + header); // Print preset message
                    if(scanner.next().toLowerCase().equals("name")){ // If the user inputs name
                        System.out.println(changeNameString); // Print preset message (prompt to change name)
                        school.setSchoolName(scanner.next()); // Access the schools class and change the schools name using setter
                        System.out.println(nameChangeConfirmString + school.getSchoolName()); // Print preset message confirming change of school name
                    }
                    else if(scanner.next().toLowerCase().equals("rooms")){ // If the user inputs rooms
                        System.out.println(changeRoomsString); // Print preset message (prompt to change number of rooms)
                        school.setRoomCount(Integer.parseInt(scanner.next())); // Access school class and change number of rooms with setter
                        System.out.println(roomChangeConfirmString + school.getRoomCount()); // Print preset message confirming change of number of rooms
                    }
                    else if(scanner.next().toLowerCase().equals("size")){ // If the user inputs size
                        System.out.println(sizeChangeString); // Print preset message (prompt change size of school)
                        school.setSchoolArea(Integer.parseInt(scanner.next())); // Access school class and change size of school using setter
                        System.out.println(sizeChangeConfirm + school.getSchoolArea() + " square feet"); // Print preset message confirming change of school size
                    }
                    break;
                case "quit": // Case for quit
                    System.out.println(quitString); // Print preset message
                    quitProgram = true; // Set quitprogram to true
                    break;
                default: // Basically else case for switch. This is triggered when none of the above cases are filled so that means they entered something invalid
                    System.out.println(error1String); // Print preset error message
                    break;
            }
        }
    }

    /* ---- METHODS ---- */
    static void printAll(String input, School school){ // PrintAll message takes in a string and a school
        /* ---- MESSAGES ---- */
        // Preset messages printed later
        String studentHeader = "---------- STUDENTS ----------";
        String teacherHeader = "---------- TEACHERS ----------";

        // Case detection
        if (input.toLowerCase().equals("students")) { // If the input is students
            System.out.println(studentHeader); // Print the student header
            if(school.students.size() > 0){ // If there are students in the arraylist to print (find out using.size)
                for (int i = 0; i < school.students.size(); i++) { // for every entry in the array list
                    // Access the school class and get the first, last, and grade of the selected index with get(i) with extra text formatting
                    System.out.println("Name: " + school.students.get(i).getFirstName() + " " + school.students.get(i).getLastName() + "\t\t\t\t\tGrade: " + school.students.get(i).getGrade() + "\t\tStudent ID: " + school.students.get(i).getStudentID());
                }
            }
        }
        else if (input.toLowerCase().equals("teachers")){ // If the input is teachers
            System.out.println(teacherHeader); // Print teacher header
            if(school.teachers.size() > 0){ // If there are teachers in the arraylist to print
                for(int i = 0; i < school.teachers.size(); i++){ // For every entry in the array list
                    // Access the school class and get the first and last name of the teacher to print using .get(i)
                    System.out.println("Name: " + school.teachers.get(i).getFirstName() + " " + school.teachers.get(i).getLastName() + "\t\t\t\t\tTeacher ID: " + school.teachers.get(i).getTeacherID());
                }
            }
        }
        else if(input.toLowerCase().equals("all")){ // Otherwise if they entered all
            printAll("students", school); // Use this function and print all students
            printAll("teachers", school); // Use this function and print all teachers
        }
    }
}
