import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkoutMenu {

    ArrayList<excercise> workout = new ArrayList<excercise>();

    public static void main(String[] args) {
        System.out.println("Welcome to the workout Menu");
        MainMenu();

    }


    public static void MainMenu() {
        //Initial choices main menu
        System.out.println("***************************************");
        System.out.println("Please select your command: ");
        System.out.println("1. Create new workout and add a lift to it");
        System.out.println("2. Remove a lift from workout");
        System.out.println("3. Export Today's workout to a text file");
        System.out.println("4. Update Lift List and Personal Bests");
        System.out.println("0. Go back to main menu");
        System.out.println("***************************************");
        //Could add export to csv file too


        //While loop to check if the data inputted is correct and able to process
        while (true) {
            try {
                int choice = UserInput();
                if (choice == 1) {
                    break;
                } // If User input is valid, exit while loop
            } catch (InputMismatchException | IOException e) { //Abstract data type handling , If user inputs something other than an integer, catch an exeption
                System.out.println("Error in data type, enter a number from above");
                System.out.println(e);
                continue;
            }
        }

    }

    private static int UserInput() throws IOException {
        Scanner scan = new Scanner(System.in); //Make new scanner
        int option = scan.nextInt();

        if (option == 1) {
            OptionOneOne.newWorkout();
            return 1;
        } else if (option == 2) {
            OptionOneTwo.removeLift();
            return 1;
        } else if (option == 3) {
            OptionOneThree.saveToFile();
            return 1;
        } else if (option == 4) {
            OptionOneFive.saveWorkoutToFile();
            return 1;
        } else if (option == 0) {
            IAFINAL.MainMenu();
            return 1;
        } else {
            System.out.println("Enter a value in the range above");
            return 0;
        }
    }


}
