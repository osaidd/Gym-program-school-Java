import java.util.ArrayList;
import java.util.Scanner;

public class GlobalMethods {
    public static String showAndSelectExcercisesToUserByMuscle() { //this basically asks the user which muscle target then chooses the excersise based on that
        Scanner scan = new Scanner(System.in);
        Boolean isFound = false;

        while(isFound = true){
            outputExcercisesByMuscle();
            System.out.println("**********************************************************");
            System.out.println("Enter the muscle you want to target(Case sensitive)");
            String musclegroup = scan.nextLine();
            for(int i = 0; i<IAFINAL.AOExcercises.size(); i++){
                if(IAFINAL.AOExcercises.get(i).getMuscleTarget().equalsIgnoreCase(musclegroup)){
                    isFound = false;
                    return IAFINAL.AOExcercises.get(i).getMuscleTarget();

                }else if(musclegroup.equals("q")){
                    return "q";
                }else {
                    isFound = true;
                }
            }
            System.out.println("Not found, enter another muscle group");
        }
        return null;
    }

    public static String selectExcercise(String Muscle) {
        ArrayList<excercise> tempArray = new ArrayList <excercise>();
        for(int i = 0; i<IAFINAL.AOExcercises.size(); i++){
            if(IAFINAL.AOExcercises.get(i).getMuscleTarget().equals(Muscle)){
                tempArray.add(IAFINAL.AOExcercises.get(i));
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the value correseponding to the lift you would like to add:");
        for(int i = 0;i<tempArray.size();i++){
            System.out.printf("Enter %d for - %s%n" , i,tempArray.get(i).getName());
        }
        int selection = scan.nextInt();
        return tempArray.get(selection).getName();
    }



    public static void outputExcercisesByMuscle() {
        for(int i = 0;i<IAFINAL.AOExcercises.size();i++) {
            System.out.println("Muscle = " + IAFINAL.AOExcercises.get(i).getMuscleTarget() + "; Name = " + IAFINAL.AOExcercises.get(i).getName() + "; PB - " + IAFINAL.AOExcercises.get(i).getPersonalBest() + ";");
        }
    }

    public static int CheckBackToMenu(char argument) {
        if(argument == 'q'){
            IAFINAL.MainMenu();
            return -1;
        }
        return 0;
    }


}
