import java.util.Scanner;

public class DietMenu {

    public static void MainMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your weight(in KG): ");
        double UserWeight = scan.nextDouble();
        System.out.println("Enter your height(in CM): ");
        double UserHeight = scan.nextDouble();
        System.out.println("Enter your age: ");
        int UserAge = scan.nextInt();

        SelectionMenu(UserWeight, UserHeight, UserAge);
    }

    private static void SelectionMenu(double UserWeight, double UserHeight, int UserAge) {
        Scanner scan = new Scanner(System.in);
        boolean loopIF = true;
        System.out.println("Enter the calculation you would like: ");
        System.out.println("1. Calculate your BMI");
        System.out.println("2. Calculate your daily caloric needs");
        System.out.println("3. Calculate your daily protein requirements");
        System.out.println("4. Exit to Main Menu");


        while(loopIF == true){
            int choice = scan.nextInt();
            if(choice == 1){
                CalcBMI(UserWeight,UserHeight,UserAge);
                loopIF = false;
            } else if (choice == 2){
                CalcCal(UserWeight,UserHeight,UserAge);
                loopIF = false;
            } else if (choice == 3){
                CalcPro(UserWeight,UserHeight,UserAge);
                loopIF = false;
            } else if(choice == 4){
                IAFINAL.MainMenu();
            } else {
                System.out.println("Enter a value in the range above");
                loopIF = true;
            }
        }
    }


    private static void CalcBMI(Double UserWeight, Double UserHeight, int UserAge) {
        double formulaHeight = Math.pow(UserHeight/100, 2); //Reformat user height for calc
        double userBMI = UserWeight / formulaHeight; //Using weight and formatted height
        System.out.println("Your BMI is: " + userBMI); //output BMI
        SelectionMenu(UserWeight,UserHeight,UserAge); //Return to main Diet Menu

    }

    private static void CalcCal(Double UserWeight, Double UserHeight, int UserAge) {
        double Formula = 66 +  (6.2 * UserWeight) + (12.7 * UserHeight) - (6.76 * UserAge) * 1.55;
        System.out.println("Your daily caloric needs to maintain weight is: " + Formula + " kcals a day");
        SelectionMenu(UserWeight,UserHeight,UserAge); //return to menu
    }

    private static void CalcPro(Double UserWeight, Double UserHeight, int UserAge) {
        Scanner scan = new Scanner(System.in); //initialize scanner
        System.out.println("Enter your bodyfat percentage"); //ask user for body fat percentage
        double bodyfat = scan.nextDouble(); //store value
        double trueWeight = UserWeight * ((100-bodyfat) / 100); //true muscle mass in body
        double Protein = 2.2 * trueWeight; //use formula
        System.out.println("Your daily protein Needs are: " + Protein + " grams per day"); //output
        SelectionMenu(UserWeight,UserHeight,UserAge); //return to main menu
    }
}
