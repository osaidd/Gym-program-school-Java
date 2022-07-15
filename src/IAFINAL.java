
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IAFINAL {

    static ArrayList<excercise> AOExcercises = new ArrayList<excercise>();//Instantiate ArrayList
    // of the exercise class and make it static so that the entire program uses this instance of the ArrayList.


    public static void main(String[] args) throws IOException {
        PreBoot.LoadIn();
        System.out.println("Welcome to the fitness tracking program");
        MainMenu();
        }


    public static void MainMenu() {
       //Initial choices main menu
        System.out.println("***************************************");
        System.out.println("Please select your command: ");
        System.out.println("1. Add to the exercise table");
        System.out.println("2. View the exercise Table");
        System.out.println("3. Delete a lift");
        System.out.println("4. Workout Menu");
        System.out.println("5. Export to Excel");
        System.out.println("6. Diet Menu");
        System.out.println("0. Exit Program");
        System.out.println("***************************************");

        //While loop to check if the data inputted is correct and able to process
        while(true){
            try{
                int choice = UserInput();
                if (choice == 1){break;} // If User input is valid, exit while loop
            }catch (InputMismatchException e) { //Abstract data type handling ,
                // If user inputs something other than an integer, catch an exeption
                System.out.println("Error in data type, enter a number from above");
                continue;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static int UserInput() throws IOException {
        Scanner scan = new Scanner(System.in); //Make new scanner
        int option = scan.nextInt();

        if(option == 1){
            OptionOne.AddTable();
            return 1;
        }else if (option == 2) {
            OptionTwo.viewTable();
            return 1;
        }else if(option == 3) {
            OptionThree.RemoveItem();
            MainMenu();
            return 1;
        }else if (option == 4){
            WorkoutMenu.MainMenu();
            return 1;
        }else if(option == 5){
         OptionFive.createFile();
         return 1;
        }else if(option == 7){
            try {
                OptionSix.UpdateCSV(IAFINAL.AOExcercises);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 1;
        } else if (option == 6){
            DietMenu.MainMenu();
            return 1;
        }
        else if (option == 0){
            return 1;
        }else {
            System.out.println("Enter a value in the range above");
            return 0;
        }
    }
}
