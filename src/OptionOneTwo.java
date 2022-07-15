import java.util.ArrayList;
import java.util.Scanner;

public class OptionOneTwo {

    public static void removeLift(){
        Scanner scan = new Scanner(System.in);

        myWorkouts.outputQueue(); //output all of the workout lifts
        // stored in the program to the user
        removeFromArray(); //run method to remove one of these

        exitToMenu();

    }


    private static void removeFromArray() {
        boolean continueloop = true; //set initial condition for while loop
        Scanner scan = new Scanner(System.in);
        String choice = null; //initialise outside of the loop to ensure that a user can input the lift name again if he enters incorrectly
        while(continueloop = true){ //set condition of the loop to run forever until condition is met
            System.out.println("Enter the name of the Excersise you would like to remove. enter 'q' to exit");
            choice = scan.nextLine(); //initialize choice to the input by user
            for(int i = 0; i < myWorkouts.workoutArrayList.size(); i++){ //Iterate through ArrayList containing all exercises
                if(choice.equalsIgnoreCase(myWorkouts.workoutArrayList.get(i).getName())){ //If User input = The chosen element in array:
                    myWorkouts.workoutArrayList.remove(i); //remove it from the workout
                    System.out.println("Successfully deleted.");
                    return;
                } else if(choice.equalsIgnoreCase("q")) { //Special case: return to main menu
                    WorkoutMenu.MainMenu();
                    return;
                }
            }
        }
    }

    private static void outputQueue(ArrayList<workoutlift> myArrayList) {
        for(int j = 0; j< myArrayList.size(); j++){
            System.out.println(" -|-" + myArrayList.get(j).getName() + " -|-" + myArrayList.get(j).getMuscleTarget() + "-|-" + myArrayList.get(j).getWeight() + "kg -|-" + myArrayList.get(j).getSets() + " sets -|-" + myArrayList.get(j).getReps() + " reps -|-");
        }
    }

    private static ArrayList<workoutlift> changeintoArrayList() {
        ArrayList<workoutlift> myArrayList = new ArrayList<workoutlift>();
        for(int i = 0; i< myWorkouts.workoutArrayList.size(); i++){
            myArrayList.set(i, myWorkouts.workoutArrayList.get(i));
        }
        return myArrayList;

    }


    private static void exitToMenu() {
        System.out.println("Press q to add another lift");
        System.out.println("Press w to go back to main menu");
        Scanner scan = new Scanner(System.in);
        char ans = scan.nextLine().charAt(0);
        if (ans == 'q') {
            removeLift();
        } else if (ans == 'w') {
            WorkoutMenu.MainMenu();
        }
    }
}
