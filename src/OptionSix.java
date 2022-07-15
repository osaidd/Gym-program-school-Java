import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OptionSix {

    public static void UpdateCSV(ArrayList<excercise> array) throws IOException {
        String path = "C:\\Users\\osaid\\Desktop\\IAFINAL//AOLifts.csv"; //Path to main CSV file
        FileWriter fw = new FileWriter(path);
        BufferedWriter br = new BufferedWriter(fw); //Instantiate the writer
        br.write("Name" + "," + "MuscleTargeted" + "," + "Weight" + "PersonalBest"); //Set headings
        br.newLine();
        for(int i = 0; i<IAFINAL.AOExcercises.size(); i++){ //Using for loop iterate through every element in the stored ArrayList
            br.write(IAFINAL.AOExcercises.get(i).CSVString()); //Write each element to the CSV file using
            // the method which converts the excercise object into a CSV string
            br.newLine(); //Create new line
        }
        br.flush();//Flush and close the Bufferedwriter
        br.close();
        System.out.println("Successfully changed the data, press q to go back to main menu, press anything else to exit program");
        //Output confirmation message and option to return to menu
        Scanner scan = new Scanner(System.in);//Create scanner object to recieve input
        if(GlobalMethods.CheckBackToMenu(scan.nextLine().charAt(0)) == 0){System.exit(10);}//Use globalmethods class to verify input
        IAFINAL.MainMenu();
    }
}
