import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OptionOne {




    public static void AddTable() throws IOException {
        char leavetomenufromweight = 'a';
        System.out.println("Add to Table Selected");
        System.out.println("");

        String liftname = Addliftname(); //Ask user for name of the Exercise
        if(GlobalMethods.CheckBackToMenu(liftname.charAt(0)) == -1){return;};//Prompt to go back to menu

        String muscletarget = Addmuscletarget(); //Ask user for name of the Exercise
        if(GlobalMethods.CheckBackToMenu(muscletarget.charAt(0)) == -1){return;};

        Double startweight = Addstartweight();//Ask user for name of the Exercise
        if(startweight == -1.0){leavetomenufromweight = 'q';}
        if(GlobalMethods.CheckBackToMenu(leavetomenufromweight) == -1){return;};

        excercise myLift = new excercise(liftname,muscletarget,startweight); //Initialize new exercise
        // with parameters inputted above
        IAFINAL.AOExcercises.add(myLift); //Add 'myLift' into the ArrayList

        myLift.createDailyWeightTrackingFile();
        myLift.addWeightToDailyWeightTrackingFile(myLift.getWeight());
        myLift.createPBTrackingFile();
        myLift.addPBToPBTrackingFile();


        int size = IAFINAL.AOExcercises.size() - 1;
        String name = IAFINAL.AOExcercises.get(size).getName();
        String muscle = IAFINAL.AOExcercises.get(size).getMuscleTarget();
        Double weight = IAFINAL.AOExcercises.get(size).getWeight();
        Double pb = IAFINAL.AOExcercises.get(size).getPersonalBest();

        addWholeProgramArrayIntoArrayCSVFile(name, muscle, weight,pb);


        System.out.println("Successfully added to the List and created 2 file/s \n\n" );
        IAFINAL.MainMenu();
    }

    private static void addWholeProgramArrayIntoArrayCSVFile(String name, String muscle, Double weight, Double pb) throws IOException {
        String path = "C:\\Users\\osaid\\Desktop\\IAFINAL//AOLifts.csv"; //Change File path at the end
        FileWriter fw = new FileWriter(path,true);
        BufferedWriter br = new BufferedWriter(fw);

        br.write(name + "," + muscle + "," + weight + "," + pb);
        br.newLine();
        br.flush();
        br.close();

        System.out.println("Added to AOLifts.csv");
    }


    private static String Addliftname() {
        Scanner scan = new Scanner(System.in); //initialize Scanner
        System.out.println("Enter the name of the Exercise, enter the letter q to exit to main menu");
        String liftname = scan.nextLine(); //Get user input after prompt
        return liftname; //return to main method

    }

    private static String Addmuscletarget() {
        Scanner scan = new Scanner(System.in);//initialize Scanner
        System.out.println("Enter the Muscles Targeted, enter the letter q to exit to main menu,");
        String muscletarget = scan.nextLine(); //Get user input after prompt
            return muscletarget; //return to main method
    }

    private static double Addstartweight() {
        String prompt = "Enter the Starting Weight, enter the number -1 to go to main menu";
        Double startweight = isValueCompatible(prompt); //Get user input after prompt
            return startweight; //return to main method
    }

    private static Double isValueCompatible(String prompt) {
        Scanner scan = new Scanner(System.in);//initialize Scanner
        while(true){ //Loop forever until certain condition met
            try{
                System.out.println(prompt); //output message in method above
                int temp = Integer.parseInt(scan.nextLine()); //parse the user input as int
                Double startweight = Double.valueOf(temp); //parse the int as a double
                return startweight; //return the input as the new double
            } catch(NumberFormatException e){ //catch any format exception
                System.out.println("Caught NumberFormatExeption"); //display actual exception
                System.out.println("Invalid entry, enter the value again"); //tell user to input again
            }
        }
    }


}
