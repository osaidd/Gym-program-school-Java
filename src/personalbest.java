import java.time.LocalDate;

    public class personalbest extends excercise {
    public LocalDate AchievementDate;

    public LocalDate getAchievementDate() {
        return AchievementDate;
    }

    public void setAchievementDate(LocalDate achievementDate) {
        AchievementDate = LocalDate.now();
    }

    public personalbest() {
        AchievementDate = LocalDate.now();;
    }

    public personalbest(String name, String muscleTarget, Double weight, LocalDate achievementDate) {
        super(name, muscleTarget, weight);
        AchievementDate = LocalDate.now();;
    }

}
