import java.util.Scanner;

/**
 * A program that reads a users input
 * of a room's length, width, and height
 * then prints the area, perimeter, and volume
 * as many times as the user needs.
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class LabOne {
    private static double myArea = 0.0;
    private static double myPerimeter = 0.0;
    private static double myVolume = 0.0;
    private static boolean doAgain = true;

    private static Scanner scnr = new Scanner(System.in);

    /**
     * Prompts the user for a measurement
     * then returns their input to be stored
     * as a primitive variable.
     *
     * @param myMeasurement the measurement that you're asking for, capitalized ("Length").
     * @return takes the user's input and sets it as the value of a double.
     */
    private static double setMeasurement (String myMeasurement) {
        double tempDouble = 0.0;

        System.out.print("Enter " + myMeasurement + ": ");
        tempDouble = scnr.nextDouble();
        tempDouble = Math.abs(tempDouble); //converts negative to a positive

        return tempDouble;
    }

    /**
     * receives the room's length, width, and height
     * as arguments and uses them to calculate the
     * area, perimeter, and volume of the room.
     *
     * @param myLength the user's input length.
     * @param myWidth the user's input width.
     * @param myHeight the user's input height.
     */
    private static void getMeasurements (double myLength, double myWidth, double myHeight) {
        myArea = myLength * myWidth;
        myPerimeter = ((myLength * 2) + (myWidth * 2));
        myVolume = ((myLength * myWidth) * myHeight);
    }
    /**
     * Prints out the area, perimeter, and volume
     * of the room being measured.
     */
    private static void printMeasurements(){
        System.out.println("Area: " + myArea);
        System.out.println("Perimeter: " + myPerimeter);
        System.out.println("Volume: " + myVolume);
        System.out.println("");
    }
    /**
     * asks user if they want to continue and then checks their input
     * for yes, no, a test result, or an incorrect input
     */
    private static void inputCheck() {
        boolean correctInput = true; // will check that user has input 'n', 'N', 'y', or 'Y'
        char userContinueCheck = '0'; // will check that user wants to repeat the program

        do {
            System.out.print("Continue? (y/n): ");
            userContinueCheck = scnr.next("[a-zA-Z]").charAt(0); // accepts a letter as input

            switch (userContinueCheck) {
                case 'y':
                case 'Y':
                    correctInput = true; // 'y' and 'Y' are correct input
                    doAgain = true; // will repeat the main program
                    break;
                case 'n':
                case 'N':
                    correctInput = true; // 'n' and 'N' are correct input
                    doAgain = false; // will exit the main program
                    break;
                case '0':
                    correctInput = true; // can repeat test if tester wants
                    System.out.println("Your userContinueCheck has failed.");
                    break;
                default:
                    correctInput = false; // makes the doWhile loop ask for another input
                    System.out.println("Incorrect Input!"); // yells at you for misbehavin'
                    System.out.println("");
                    break;
            }
        }
        // repeats the loop if the user gave the wrong input
        while (!correctInput);
    }
    /**
     * The main method of my program
     *
     * @param args default argument for main()
     */
    public static void main(String[] args) {
        double myLength = 0.0;
        double myWidth = 0.0;
        double myHeight = 0.0;

        String welcomeMessage = "Welcome to Grand Circus's Room Detail Generator!";
        String goodbyeMessage = "Have a great day!";

        System.out.println(welcomeMessage);

        /* Do-While Loop that executes the code then
        asks the user if they want to continue repeats
        only if the user enters 'y' or 'Y' */
        do {
            System.out.println("");

            // Receive these measurements from the user
            myLength = setMeasurement("Length");
            myWidth = setMeasurement("Width");
            myHeight = setMeasurement("Height");

            // Calculate area, perimeter, and volume
            getMeasurements(myLength, myWidth, myHeight);

            // Print the results:
            System.out.println("");
            printMeasurements();

            // Asks user y/n, checks for correct input
            inputCheck();
        }
        // repeats code only if the user enters 'y' or 'Y'
        while (doAgain);

        System.out.println("");
        System.out.println(goodbyeMessage);
    }
}
