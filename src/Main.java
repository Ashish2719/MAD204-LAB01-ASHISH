
import java.util.ArrayList;
import java.util.Scanner;


 * Course: MAD204: Java Development
 * Lab 1
 * Student Name: Ashishkumar Prajapati
 * Student ID: A00194842
 * Date: September 21, 2025
 *
 * Description:
 * This is the main Gradebook & Utilities program.
 * It allows adding students, entering grades, displaying results,
 * and running utilities (operator demo, type casting, recursion).
 */

public class Main {
    private static ArrayList<Student> students=new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Gradebook Menu");
            System.out.println("1. Add Student");
            System.out.println("2. Enter Grades");
            System.out.println("3. Show All Students");
            System.out.println("4. Utilities");
            System.out.println("5. Exit");

            int choice = getInt("Choose Option:");

            switch (choice){

                case 1: addStudent();
                break;
                case 2: enterGrade();
                    break;
                case 3: showStudents();
                    break;
                case 4:  utilitiesMenu();
                    break;
                case 5: {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default:
                    System.out.println("Invalid choice, try again");
            }
        }
    }

    private  static void addStudent(){
        int id = getInt("Enter student Id:");
        System.out.println("Enter student name:");
        String name = sc.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student added!");
    }

    // Enter grades for a student
    private static void enterGrade(){
        if (students.isEmpty()) {
            System.out.println("No student yet!");
            return;
        }
        int id = getInt("Enter student ID to add Grades");
        for (Student s: students) {
            if(s.getId() == id) {
                for (int i = 0; i < 5; i++) {
                    double g = getDouble("Enter grade" + (i + 1) + ": ");
                    s.setGrade(i, g);
                }
                return;
            }
        }
        System.out.println("Student not found");
        }

        private static void  showStudents(){
        if (students.isEmpty()) {
            System.out.println("No student to display");
            return;
        }
        for (Student s : students){
            System.out.println(s);
        }
    }

//    Utilities Menu
    private static void utilitiesMenu() {
        System.out.println("\n-- Utilities------");
        System.out.println("1. Operator Demo");
        System.out.println("2. Type Casting");
        System.out.println("3. Recursion Coundown");

        int choice = getInt("Choose option:");
        switch (choice) {
            case 1:
                operatorDemo();
                break;
            case 2:
                castingDemo();
                break;
            case 3: {
                int n = getInt("Enter number for countdown:");
                countdown(n);
                break;
            }
            default:
                System.out.println("Invalid choice!");
        }
    }

//    Operator precendence demo

    private static void operatorDemo(){
        System.out.println("2+ 3* 4 =" + (2 + 3 * 4));
        System.out.println("(2 + 3) * 4 = " + ((2 + 3) * 4));
        System.out.println("Multiplication has higher precedence.");
    }
    private static void castingDemo(){
        int x= 10;
        double y= x;
        double z=9.8;
        int w= (int) z;
        System.out.println("int to double: "+x+" --> " + y);
        System.out.println("double to int: " + z + " --" + w);
        }

//        recursion countdown

    private static void countdown(int n){
        if (n<0) {
            System.out.println("Negative not allowed");
            return;
        }
        if (n == 0 ){
            System.out.println("Done");
        }else {
            System.out.println(n);
            countdown(n - 1);
        }
    }

//    get int with validation
    private static int getInt (String prompt){
        while (true) {
            try {
                System.out.println(prompt);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer, try again");
            }
        }
    }
//    Get double with validation
    private static double getDouble (String prompt) {
        while (true){
            try {
                System.out.println(prompt);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number, try again");
            }
        }
    }
}