import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class OptionOneThree {
    public static void saveToFile() {

        if(myWorkouts.workoutArrayList.isEmpty() == true) { //If there are no lifts in the workout
            System.out.println("No workouts in the program please try create one");
            WorkoutMenu.MainMenu(); //direct user back to the main menu
            return;
        }

        try {

            String path = "C:\\Users\\osaid\\Desktop\\IAFINAL\\Workouts//Workout-" + java.time.LocalDate.now() + ".txt";
            //Create the file, whose name also includes the date

            writeFile(path); //Run method which writes all the exercises into the file

            System.out.println("Saved Workout into filename:- " + "Workout-" + java.time.LocalDate.now()); //Tell user that file is saved
            System.out.println("Press q to go back to main menu, press anything else to exit program"); //Output choices to user
            Scanner scan = new Scanner(System.in);
            if(GlobalMethods.CheckBackToMenu(scan.nextLine().charAt(0)) == 0){System.exit(10);}
            //run validation/verification method to determine users choice
            WorkoutMenu.MainMenu();

        } catch (Exception e) {
            System.out.println("Exception: " + e + " in class Workout"); //output possible error to user
        }

    }

    public static void saveToAdminFiles(){
        String path = "C:\\Users\\osaid\\Desktop\\IAFINAL\\AdminFiles\\Readworkout//Workout-" + java.time.LocalDate.now() + ".txt";
        writeFile(path);
    }

    private static void writeFile(String path) {
        try{
            FileWriter fw = new FileWriter(path); //instantiate
            BufferedWriter br = new BufferedWriter(fw); //instantiate
            br.write("Name" + "-|-" + "MuscleTargeted" + "-|-" + "Weight" + "-|-" + "Sets" + "-|-" + "Reps");
            //Write the headings on the text file

            br.newLine(); //next line
            for (int i = 0; i < myWorkouts.workoutArrayList.size(); i++) { //Loop for every excercise in the main ArrayList
                br.write("-|-" + myWorkouts.workoutArrayList.get(i).getName()  //write the name
                        + "-|-" + myWorkouts.workoutArrayList.get(i).getMuscleTarget()  //write the muscle target
                        + "-|-" + myWorkouts.workoutArrayList.get(i).getWeight() + "kg -|-" //write the weight
                        + myWorkouts.workoutArrayList.get(i).getSets() + " sets -|-"  //write the number of sets
                        + myWorkouts.workoutArrayList.get(i).getReps() + " reps -|-"); //write the number of reps

                br.newLine(); //new line before repeating this process
            }
            br.flush(); //write the contents into the given file
            br.close();
        }catch (Exception e) {
            System.out.println("Exception: " + e + " in class Workout");
        }


    }
}
