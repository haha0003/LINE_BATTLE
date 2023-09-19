import java.util.Random;
import java.util.Scanner;

public class Line5 {
    public static void main(String[] args) {
        new Line5().run();
    }

    final int playerBaseCamp = 10;
    int playerPosition = 10;
    int playerSoldiers = 25;
    int playerShots = 2500;
    boolean isGameRunning = true;

    final int enemyBaseCamp = -10;
    int enemyPosition = -10;
    int enemySoldiers = 25;
    int enemyShots = 2500;

    Scanner in = new Scanner(System.in);
    Random random = new Random();

    private void run() {
        welcomeMessage();
        playerStart();
        enemyStart();
        while (isGameRunning){
            playerTurn();
            if (!isGameRunning) break;
            enemyTurn();
        }
    }

    public void welcomeMessage(){
        System.out.println("Welcome to line battle");
        System.out.println("The game is simple (making it was not)");
        System.out.println("Press enter to roll dice and begin game: ");
        in.nextLine();
    }

    public void playerStart(){
        int dice = random.nextInt(6)+1;
        System.out.println("You rolled a: " + dice);
        playerPosition -= dice;
        System.out.println("You now stand on: " + playerPosition);
    }

    public String playerChoice(){
        System.out.println("\nChoose your move: ");
        System.out.println("Move FORWARD: press 'f'");
        System.out.println("Move BACK: press 'b'");
        System.out.println("ATTACK: press 'a'");
        System.out.println("STATUS: press 's'");
        System.out.println("QUIT game: press 'q' \n");
        return in.nextLine();
    }

    public void playerTurn(){
       while (isGameRunning && playerSoldiers > 0){
        String choice = playerChoice();
            if (choice.equalsIgnoreCase("f")){
                playerForward();
            } else if (choice.equalsIgnoreCase("b")) {
                playerBack();
            } else if (choice.equalsIgnoreCase("a")) {
                playerAttack();
            } else if (choice.equalsIgnoreCase("s")) {
                playerStatus();
            } else if (choice.equalsIgnoreCase("q")) {
                quitGame();
            } else {
                System.out.println("Please enter next move: ");
            }
    }}

    public void playerForward(){
        System.out.println("You chose to: move FORWARD");

        int dice = random.nextInt(6)+1;
        int  move = (dice % 2 == 0) ? 2 : 1;
        if (playerPosition - move >= -10){
            playerPosition -= move;
            System.out.println("You moved " + move + " fields forward");
        } else {
            System.out.println("You can't move any further forward");
        }
        System.out.println("Your current position is: " + playerPosition);
    }

    public void playerBack(){
        System.out.println("You chose to: move BACK");

        int dice = random.nextInt(6) + 1;
        int move;
        if (dice <= 2) {
            move = 1;
        } else if (dice <= 4) {
            move = 2;
        } else {
            move = 3;
        }

        if (playerPosition + move <= 10){
            playerPosition += move;
            playerShots += 250;
            System.out.println("You moved " + move + " fields back");
        } else {
            System.out.println("You can't move any further back");
        }
        System.out.println("Your current position is: " + playerPosition);
    }

    public void playerAttack(){

    }

    public void playerStatus(){
        System.out.println("You chose to: view STATUS");
        System.out.println("SHOTS: ");
        System.out.println("You have: " + playerShots + " shots available");
        System.out.println("Enemy has: " + enemyShots + " shots available");
        System.out.println("SOLDIERS: ");
        System.out.println("You have: " + playerSoldiers + " soldiers available");
        System.out.println("Enemy has: " + enemySoldiers + " soldiers available");
        System.out.println("POSITION: ");
        System.out.println("Your current position is: " + playerPosition);
        System.out.println("Enemy current position is: " + enemyPosition);
    }

    public void quitGame(){
        System.out.println("You chose to: QUIT GAME");
        System.out.println("You lose!");
        isGameRunning = false;
    }




    public void enemyStart(){
        int dice = random.nextInt(6)+1;
        System.out.println("\nEnemy rolled a: " + dice);
        enemyPosition += dice;
        System.out.println("Enemy now stands on: " + enemyPosition);
    }


    public void enemyTurn(){
        int dice = random.nextInt(4)+1;
        if (dice == 1){
            enemyForward();
        } else if (dice == 2) {
            enemyBack();
        } else if (dice == 3){
            enemyAttack();
        } else {
            enemyStatus();
        }
    }


    public void enemyForward(){
        System.out.println("Enemy chose to: move FORWARD");

        int dice = random.nextInt(6)+1;
        int  move = (dice % 2 == 0) ? 2 : 1;
        if (enemyPosition - move >= 10){
            enemyPosition += move;
            System.out.println("Enemy moved " + move + " fields forward");
        } else {
            System.out.println("Enemy can't move any further forward");
        }
        System.out.println("Enemy current position is: " + enemyPosition);
    }

    public void enemyBack(){
        System.out.println("Enemy chose to: move BACK");

        int dice = random.nextInt(6) + 1;
        int move;
        if (dice <= 2) {
            move = 1;
        } else if (dice <= 4) {
            move = 2;
        } else {
            move = 3;
        }

        if (enemyPosition - move <= -10){
            enemyPosition -= move;
            enemyShots += 250;
            System.out.println("Enemy moved " + move + " fields back");
        } else {
            System.out.println("Enemy can't move any further back");
        }
        System.out.println("Enemy current position is: " + enemyPosition);
    }

    public void enemyAttack(){

    }

    public void enemyStatus(){
        System.out.println("Enemy chose to: view STATUS");
        System.out.println("SHOTS:");
        System.out.println("Enemy has: " + enemyShots + " shots available");
        System.out.println("You have: " + playerShots + " shots available");
        System.out.println("SOLDIERS:");
        System.out.println("Enemy has: " + enemySoldiers + " soldiers available");
        System.out.println("You have: " + playerSoldiers + " soldiers available");
        System.out.println("POSITION:");
        System.out.println("Enemy current position is: " + enemyPosition);
        System.out.println("Your current position is: " + playerPosition);

    }





}