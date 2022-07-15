import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PreBoot {


    public static void LoadIn() throws IOException {

        String path = "C:\\Users\\osaid\\Desktop\\IAFINAL//AOLifts.csv"; //path to folder
        FileReader fw = new FileReader(path); // instantiate
        BufferedReader br = new BufferedReader(fw); // instantiate

        String line;
        br.readLine();

        while((line= br.readLine()) != null){ //loop while the program can read the line
                String data[] = line.split(","); //split the entire line into an array, which is separated by a comma
                excercise newExcercise = new excercise(); //Make a new instance of the class excercise

                newExcercise.setName(data[0]); //set name to the first element in the array

                newExcercise.setMuscleTarget(data[1]); //set the muscle target to the second element

                Double newFinalWeight = Double.parseDouble(data[2]); //set the weight to the third element
                newExcercise.setWeight(newFinalWeight);

                Double newFinalpb = Double.parseDouble(data[3]); //set personal best to the 4th element in the array
                newExcercise.setPersonalBest(newFinalpb);

                IAFINAL.AOExcercises.add(newExcercise); // Add the excercise to the main ArrayList of the program
                System.out.println("Added  -  " + newExcercise.getName()); //output confirmation to the user
        }
        br.close();
        }

    }
