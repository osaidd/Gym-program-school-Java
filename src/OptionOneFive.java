import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class OptionOneFive {

    static Queue listOfNewPB = new ArrayDeque<excercise>();

    public static void saveWorkoutToFile() throws IOException {
        updateLiftValuesInCSV();
        checkIfThereIsNewPB();
        addPBsToFile();
        OptionSix.UpdateCSV(IAFINAL.AOExcercises);

    }

    private static void updateLiftValuesInCSV() throws IOException {
        if(myWorkouts.workoutArrayList.isEmpty() == true){
            System.out.println("No workouts in the program please try create one");

            WorkoutMenu.MainMenu();
            return;
        }
        for(int i = 0; i < myWorkouts.workoutArrayList.size(); i++){
            String excerciseName = myWorkouts.workoutArrayList.get(i).getName();
            for(int j = 0;j < IAFINAL.AOExcercises.size();j++){
                if(IAFINAL.AOExcercises.get(j).getName().equalsIgnoreCase(excerciseName)){
                    IAFINAL.AOExcercises.get(j).addWeightToDailyWeightTrackingFile(myWorkouts.workoutArrayList.get(i).getWeight());
                }
            }
        }
    }


    private static void checkIfThereIsNewPB() {

        try{
            for(int i = 0; i<myWorkouts.workoutArrayList.size(); i++){
                String newExcerciseName = myWorkouts.workoutArrayList.get(i).getName();
                Double newExcerciseWeight = myWorkouts.workoutArrayList.get(i).getWeight();
                excercise originalLift = null;
                int indexOfExcerciseInAOLifts = -1;
                Double oldPersonalBest = 10000000000.0;

                for(int j = 0;j<IAFINAL.AOExcercises.size();j++){
                    String originalExcerciseName = IAFINAL.AOExcercises.get(j).getName();
                    if(originalExcerciseName.equals(newExcerciseName)){ originalLift = IAFINAL.AOExcercises.get(j); oldPersonalBest = IAFINAL.AOExcercises.get(j).getPersonalBest();indexOfExcerciseInAOLifts = j;}
                }

                if(newExcerciseWeight > oldPersonalBest ){
                    IAFINAL.AOExcercises.get(indexOfExcerciseInAOLifts).setPersonalBest(newExcerciseWeight);
                    IAFINAL.AOExcercises.get(indexOfExcerciseInAOLifts).setDate();
                    System.out.println("Successfully updated the PersonalBest for: " + IAFINAL.AOExcercises.get(indexOfExcerciseInAOLifts).getName() + " to " + IAFINAL.AOExcercises.get(indexOfExcerciseInAOLifts).PersonalBest);
                    listOfNewPB.add(originalLift);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private static void addPBsToFile() throws IOException {
        while(listOfNewPB.isEmpty() != true){
            excercise chosenExcercise = (excercise) listOfNewPB.remove();
            chosenExcercise.addPBToPBTrackingFile();
        }
    }


//Save to CSV File, try catch to create the file

    //Also, when iterating through the array for every excercise, open the file with the weights and the dates and write the current weight and date to that file
    //Once finished writing thne

    //Write the file and the headers
    //Comma separated to the file doesnt need to look nice

}
