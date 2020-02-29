import java.util.Scanner;

public class TuitionManager {
    static Scanner stdin;
    static StudentList students;

    public static void main(String[] args) {
        stdin = new Scanner(System.in);
        students = new StudentList();

        boolean done = false;

        while (!done) {
            String command = stdin.nextLine();
            String[] splitCommand = command.split(" "); // Split the command given into parts
            String fname, lname;
            int credit, funds;
            boolean status;

            switch (command.charAt(0)) {
                case 'I': // In-State Student
                    if (splitCommand.length != 5 || splitCommand[0].length() != 1) {
                        printError(splitCommand[0]);
                        break;
                    }
                    fname = splitCommand[1];
                    lname = splitCommand[2];
                    credit = Integer.parseInt(splitCommand[3]);
                    funds = Integer.parseInt(splitCommand[4]);
                    addInState(fname, lname, credit, funds);
                    break;
                case 'O': // Out-of-State Student
                    if (splitCommand.length != 5 || splitCommand[0].length() != 1) {
                        printError(splitCommand[0]);
                        break;
                    }
                    fname = splitCommand[1];
                    lname = splitCommand[2];
                    credit = Integer.parseInt(splitCommand[3]);
                    status = splitCommand[4].equals("T") ? true : false;
                    addOutState(fname, lname, credit, status);
                    break;
                case 'N': // International Student
                    if (splitCommand.length != 5 || splitCommand[0].length() != 1) {
                        printError(splitCommand[0]);
                        break;
                    }
                    fname = splitCommand[1];
                    lname = splitCommand[2];
                    credit = Integer.parseInt(splitCommand[3]);
                    status = splitCommand[4].equals("T") ? true : false;
                    addInternational(fname, lname, credit, status);
                    break;
                case 'R': // Remove
                    if (splitCommand.length != 3 || splitCommand[0].length() != 1) {
                        printError(splitCommand[0]);
                        break;
                    }
                    fname = splitCommand[1];
                    lname = splitCommand[2];
                    remove(fname, lname);
                    break;
                case 'P': // Print
                    if (splitCommand.length != 1 || splitCommand[0].length() != 1) {
                        printError(splitCommand[0]);
                        break;
                    }
                    print();
                    break;
                case 'Q': // Quit
                    if (splitCommand.length != 1 || splitCommand[0].length() != 1) {
                        printError(splitCommand[0]);
                        break;
                    }
                    System.out.println("Program terminated");
                    done = true;
                    break;
                default:
                    printError(splitCommand[0]);
                    break;
            }
        }
    }

    private static void remove(String fname, String lname) {
        Student removedStudent = new Instate(fname, lname, 0, 0);
        if (!students.remove(removedStudent)) {
            System.out.println(fname + " " + lname + " is not a student.");
        } else {
            System.out.println(fname + " " + lname + " has been removed.");
        }
    }

    private static void addInternational(String fname, String lname, int credit, boolean status) {
        if (credit >= 9) {
            International newStudent = new International(fname, lname, credit, status);

            if (students.contains(newStudent)) {
                System.out.println(fname + " " + lname + " is already a student.");
            } else {
                students.add(newStudent);
                System.out.println(fname + " " + lname + " has been added to the list.");
            }
        } else {
            System.out.println("Invalid credits amount.");
        }
    }

    private static void addOutState(String fname, String lname, int credit, boolean status) {
        if (credit > 0) {
            Outstate newStudent = new Outstate(fname, lname, credit, status);

            if (students.contains(newStudent)) {
                System.out.println(fname + " " + lname + " is already a student.");
            } else {
                students.add(newStudent);
                System.out.println(fname + " " + lname + " has been added to the list.");
            }
        } else {
            System.out.println("Invalid credits amount.");
        }
    }

    private static void addInState(String fname, String lname, int credit, int funds) {
        if (credit > 0) {
            Instate newStudent = new Instate(fname, lname, credit, funds);

            if (students.contains(newStudent)) {
                System.out.println(fname + " " + lname + " is already a student.");
            } else {
                students.add(newStudent);
                System.out.println(fname + " " + lname + " has been added to the list.");
            }
        } else {
            System.out.println("Invalid credits amount.");
        }
    }

    private static void print() {
        if (students.isEmpty()) {
            System.out.println("There are no students in the list!");
        } else {
            students.print();
        }
    }

    private static void printError(String command) {
        System.out.println("Command '" + command + "' not supported!");
    }
}
