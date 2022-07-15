import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OptionThree {


    public static void RemoveItem() throws IOException {
        Scanner scan = new Scanner(System.in);
        char arguement = 'a';

        System.out.println("Enter letter q to exit to main menu");
        String muscleOfChosen = GlobalMethods.showAndSelectExcercisesToUserByMuscle();

        if(muscleOfChosen.equals("q")){arguement = 'q';}
        GlobalMethods.CheckBackToMenu(arguement);

        String nameOfChosen = GlobalMethods.selectExcercise(muscleOfChosen);

        String liftname = DetermineLift(nameOfChosen);
        OptionSix.UpdateCSV(IAFINAL.AOExcercises);

    }

    private static void removeFromMainCSV(String liftname) {
        Scanner scan = new Scanner("C:\\Users\\osaid\\Desktop\\IAFINAL\\AOLifts.csv");
        ArrayList<String> tempArray = new ArrayList<>();
        int i = 0;
        while(scan.hasNextLine()){
            tempArray.add(scan.nextLine());
            i++;
        }
        for(int j = 0; j<tempArray.size();j++){
            if(tempArray.get(j).equals(liftname)){
                tempArray.remove(j);
            }
        }
    }

    private static String DetermineLift(String choice) {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < IAFINAL.AOExcercises.size(); i++){
            if(choice.equals(IAFINAL.AOExcercises.get(i).getName())){
                IAFINAL.AOExcercises.remove(i);

            }
        }

        File filepath = new File("C:\\Users\\osaid\\Desktop\\IAFINAL\\ExcersiseLifts\\" + choice + ".csv");
        File filepathPB = new File("C:\\Users\\osaid\\Desktop\\IAFINAL\\PBlifts\\" + choice + ".csv");
        filepath.delete();
        filepathPB.delete();

        System.out.println("Successfully removed: " + choice + " from the list of excersises");
        return choice;
    }
}
