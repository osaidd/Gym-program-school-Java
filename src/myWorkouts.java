import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class myWorkouts {
    static ArrayList<workoutlift> workoutArrayList = new ArrayList<workoutlift>();
    static Queue<workoutlift> liftqueue = new LinkedList<>();


    public static void outputArray(ArrayList<workoutlift> workoutArrayList){
        for(int i = 0; i<workoutArrayList.size();i++){
            System.out.println(workoutArrayList.get(i).getName());
        }
    }


    public static void outputQueue(){

        for(int i = 0; i< workoutArrayList.size(); i++){ //Iterate through the array for every element inside of it
            System.out.println(workoutArrayList.iterator()); //Output the element using .get method, and
            //using the .toString method inside of exercise class to make sure the output is properly formatted for the user
        }
    }

}

