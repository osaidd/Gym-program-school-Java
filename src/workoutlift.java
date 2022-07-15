public class workoutlift extends excercise {

    private int sets;
    private int reps;

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public workoutlift(int sets, int reps) {
        this.sets = sets;
        this.reps = reps;
    }

    public workoutlift(){
        this.sets = -1;
        this.reps = -1;
    }

    public workoutlift(String name, String muscleTarget, Double weight, int sets, int reps) {
        super(name,muscleTarget,weight);
        this.sets = sets;
        this.reps = reps;
    }

    public void setAll(String liftName, String muscle, Double weight, int sets, int reps) {
        this.Name = liftName;
        this.MuscleTarget = muscle;
        this.Weight = weight;
        this.sets = sets;
        this.reps = reps;
    }

    @Override
    public String toString() {
        return " -|-" + getName()
                + " -|-" + getMuscleTarget()
                + "-|-" + getWeight() + "kg -|-"
                + getSets() + " sets -|-"
                + getReps() + " reps -|-";
    }
}
