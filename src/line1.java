import java.util.Random;
import java.util.Scanner;


public class line1 {
    public static void main(String[] args) {
        new line1().run();
    }

    Scanner in = new Scanner(System.in);
    Random random = new Random();

    int playerBase = 10;
    int playerSoldiers = 25;
    int playerShots = 2500;
    int playerBomb = 1;


    int enemyBase = -10;
    int enemySoldiers = 25;
    int enemyShots = 2500;
    int enemyBomb = 1;



    private void run() {
        welcomeMessage();
        playerRoll();


    }


    public int dice(){
        return random.nextInt(6)+1;
    }


    public void welcomeMessage(){
        System.out.println("Welcome to LINE BATTLE");
        System.out.println("The game is simple (making it was not)");
        System.out.println("Press enter to begin game");
        in.nextLine();

    }


  public int playerRoll(){
        int playerRollResult = dice();
        System.out.println("You rolled a: " + playerRollResult);
       return playerRollResult;
   }






}