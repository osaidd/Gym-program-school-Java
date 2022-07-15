import java.util.Scanner;

public class OptionOneOne {


    
    public static void newWorkout(){
        //First ask user for which muscle to target
        //then only show those and ask user to input the name of the excersise they want
        //Then ask them for the sets and reps
        //complete
        Scanner scan = new Scanner(System.in);
        char arguement = 'a';

        System.out.println("Enter letter q to exit to main menu");
        System.out.println("**************************************************************");
        String chosenMuscle = GlobalMethods.showAndSelectExcercisesToUserByMuscle();

        if(chosenMuscle.equals("q")){arguement = 'q';}
        GlobalMethods.CheckBackToMenu(arguement);

        String chosenliftName = GlobalMethods.selectExcercise(chosenMuscle);
        insertIntoWorkoutLiftArray(chosenliftName);

        exitToMenu();

        }




    public static void insertIntoWorkoutLiftArray (String name) {
        int x = 0;
        for(int i = 0;i<IAFINAL.AOExcercises.size();i++){
            if(IAFINAL.AOExcercises.get(i).getName().equals(name)){
                x = i;
            }
        }
        String liftName = IAFINAL.AOExcercises.get(x).getName();
        String muscleTarget = IAFINAL.AOExcercises.get(x).getMuscleTarget();
        Double weight = getWeight();
        int sets = getSets();
        int reps = getReps();
        Addtolift(liftName, muscleTarget, weight, sets, reps);
    }

    private static Double getWeight() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the weight: ");
        String rawweight = scan.nextLine();
        Double sets = Double.parseDouble(rawweight);
        return sets;
    }


    private static int getSets() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the sets: ");
        int sets = scan.nextInt();
        return sets;

    }

    private static int getReps() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the reps: ");
        int reps = scan.nextInt();
        return reps;
    }

    public static void Addtolift(String liftName, String muscle, Double weight, int sets, int reps) {
            workoutlift myWorkoutlift = new workoutlift(); //Inastantiate a workout lift which is a
            //subclass of exercise and is designed to be in a format which can be presented as a workoutplan
            myWorkoutlift.setAll(liftName,muscle,weight,sets,reps); //
            myWorkouts.workoutArrayList.add(myWorkoutlift);//Push a workoutlift(object) into the Queue
            myWorkouts.outputArray(myWorkouts.workoutArrayList); //Using the output method, show the user the entire Queue
            // for confirmation purposes
            System.out.println("Added: " + myWorkoutlift.getName());

            
    }

    private static void exitToMenu() {
        System.out.println("Press q to add another lift");
        System.out.println("Press w to go back to main menu");
        Scanner scan = new Scanner(System.in);
        char ans = scan.nextLine().charAt(0);
        if (ans == 'q'){
            newWorkout();
        }else if(ans == 'w'){
            WorkoutMenu.MainMenu();
        }
    }

}
