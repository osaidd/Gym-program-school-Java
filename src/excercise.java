import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class excercise {
    public String Name;
    public String MuscleTarget;
    public Double Weight;
    public Double PersonalBest;
    public static LocalDate todayDate;
    public String Date;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPersonalBest() {
        return PersonalBest;
    }

    public void setPersonalBest(Double personalBest) {
        PersonalBest = personalBest;
    }

    public String getMuscleTarget() {
        return MuscleTarget;
    }

    public void setMuscleTarget(String muscleTarget) {
        MuscleTarget = muscleTarget;
    }

    public Double getWeight() {
        return Weight;
    }

    public void setWeight(Double weight) {
        Weight = weight;
    }

    public String getDate() {
        return Date;
    }

    public void setDate() {
        LocalDateTime now = LocalDateTime.now();
        int day = now.getDayOfMonth();
        int month = now.getMonthValue();
        int year = now.getYear();
        Date = day + "-" + month + "-" + year;
    }


    public static String getNowDate(){
        LocalDateTime now = LocalDateTime.now();
        int day = now.getDayOfMonth();
        int month = now.getMonthValue();
        int year = now.getYear();
        String date = day + "-" + month + "-" + year;
        return date;
    }

    public excercise() {
        Name = "undefined";
        MuscleTarget = "undefined";
        Weight = 0.0;
    }

    public excercise(String name, String muscleTarget, Double weight) {
        Name = name;
        MuscleTarget = muscleTarget;
        Weight = weight;
        PersonalBest = weight;
        Date = getNowDate();
    }

    @Override
    public String toString() {
        return "lift{" +
                "Name='" + Name + '\'' +
                ", MuscleTarget='" + MuscleTarget + '\'' +
                ", Weight=" + Weight +
                '}';
    }

    public String CSVString() {
        return Name + "," + MuscleTarget + "," + Weight + "," + PersonalBest;
    }

    public void createDailyWeightTrackingFile() throws IOException {
        String path = "C:\\Users\\osaid\\Desktop\\IAFINAL\\ExcersiseLifts//" + Name + ".csv"; // Determine Path
        File myFile = new File(path); //Instantiate object
        FileWriter fw = new FileWriter(path); //Instantiate object
        BufferedWriter br = new BufferedWriter(fw);//Instantiate object
        br.write("Weight" + "           " + "Date"); //Create headings needed for tracking
        br.flush(); //flush the output stream
        br.close();

    }

    public void createPBTrackingFile() throws IOException {
        String path = "C:\\Users\\osaid\\Desktop\\IAFINAL\\PBlifts//" + Name + ".csv";
        File myFile = new File(path);
        FileWriter fw = new FileWriter(path);
        BufferedWriter br = new BufferedWriter(fw);
        br.write("Weight" +  "          " + "Date");
        br.flush();
        br.close();

    }

    public void addWeightToDailyWeightTrackingFile(Double weight) throws IOException {
        String path = "C:\\Users\\osaid\\Desktop\\IAFINAL\\ExcersiseLifts//" + Name + ".csv"; //Change File path at the end
        FileWriter fw = new FileWriter(path,true); //Instantiate filewriter object which can apppend
        BufferedWriter br = new BufferedWriter(fw);
        br.newLine();
        br.write(weight +  "," + getNowDate());
        br.flush();
        br.close();
    }

    public void addPBToPBTrackingFile() throws IOException {
        String path = "C:\\Users\\osaid\\Desktop\\IAFINAL\\PBlifts//" + Name + ".csv"; //File path
        FileWriter fw = new FileWriter(path,true); //Instantiate filwriter object with the
        // ability to append to the file rather than clearing the entire file
        BufferedWriter br = new BufferedWriter(fw); //instantiate object
        br.newLine(); //Start a new line because otherwise last line in the file would
        // become overridden, in this case the last personal best achieved.
        br.write(getPersonalBest() +  "," + getNowDate()); //Write the weight of the lift along with
        // the date it was achieved
        br.flush();
        br.close(); //flush and close the output stream
    }
}
