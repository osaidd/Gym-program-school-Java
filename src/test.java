import java.io.BufferedWriter;
import java.io.FileWriter;

public class test {
    public static void main(String[] args) {

        excercise q = new excercise("q","hi",23.0);
        excercise w = new excercise("w","hi",23.0);
        excercise e = new excercise("e","hi",23.0);
        excercise r = new excercise("r","hi",23.0);
        excercise t = new excercise("t","hi",23.0);
    }

    private static void writeFileInOrder(String path) {

        try{ //try catch to ensure no crashes in program
            FileWriter fw = new FileWriter(path); //instantiate
            BufferedWriter br = new BufferedWriter(fw); //instantiate
            br.write("Name" + "-|-" + "MuscleTargeted" + "-|-" + "Weight" + "-|-" + "Sets" + "-|-" + "Reps");
            //Write the headings on the text file

            br.newLine(); //next line to not overwrite the headers
            while(myWorkouts.liftqueue.isEmpty() == false){
                br.write("-|-" + myWorkouts.liftqueue.element().getName()//write the name
                        + "-|-" + myWorkouts.liftqueue.element().getMuscleTarget()  //write the muscle target
                        + "-|-" + myWorkouts.liftqueue.element().getWeight() + "kg -|-" //write the weight
                        + myWorkouts.liftqueue.element().getSets() + " sets -|-"  //write the number of sets
                        + myWorkouts.liftqueue.element().getReps() + " reps -|-"); //write number of reps
                myWorkouts.liftqueue.remove(); //Dequeue element after use to ensure there is no infinite loop
            }

            br.flush(); //write the contents into the given file
            br.close();
        }catch (Exception e) { //print exeption to user
            System.out.println("Exception: " + e + " in class Workout");
        }
    }

}
