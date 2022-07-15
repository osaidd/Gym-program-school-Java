public class OptionTwo {
    public static void viewTable() {
        for(int i = 0;i<IAFINAL.AOExcercises.size();i++){
            System.out.printf("Liftname: %s - Muscle: %s - Weight: %f - PB:%f\n" ,IAFINAL.AOExcercises.get(i).getName(),IAFINAL.AOExcercises.get(i).getMuscleTarget(),IAFINAL.AOExcercises.get(i).getWeight(),IAFINAL.AOExcercises.get(i).getPersonalBest());
        }
        IAFINAL.MainMenu();
    }
}
