import java.util.Random;
import java.util.Scanner;

public class Line6 {
    public static void main(String[] args) {
        new Line6().run();
    }

    boolean isGameRunning = true;

    final int playerBaseCamp = 10;
    int playerPosition = 10;
    int playerSoldiers = 25;
    int playerShots = 2500;

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

        boolean gameRunning = true;

        while (gameRunning) {
            playerTurn();
            if (playerSoldiers <= 0 || !isGameRunning) {
                gameRunning = false;
            } else {
                enemyTurn();
                if (enemySoldiers <= 0) {
                    gameRunning = false;
                }
            }
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
        if (distance() <= 6){
            System.out.println("ATTACK: press 'a'");
        }if (playerPosition <= -1 && playerPosition > enemyBaseCamp){
            System.out.println("PLACE BOMB: press 'p'");
        } if (playerBombPosition() >= 6){
            System.out.println("DETONATE BOMB: press 'd'");
        }
        System.out.println("STATUS: press 's'");
        System.out.println("QUIT game: press 'q' \n");
        return in.nextLine();
    }




    public void playerTurn() {
        String choice;
            choice = playerChoice();
            if (choice.equalsIgnoreCase("f")) {
                playerForward();
            } else if (choice.equalsIgnoreCase("b")) {
                playerBack();
            } else if (choice.equalsIgnoreCase("a")) {
                playerAttack();
            } else if (choice.equalsIgnoreCase("p")) {
                playerBombPosition();
            } else if (choice.equalsIgnoreCase("d")) {
                playerDetonateBomb();
            } else if (choice.equalsIgnoreCase("s")) {
                playerStatus();
            } else if (choice.equalsIgnoreCase("q")) {
                quitGame();
            } else {
                System.out.println("Please enter a valid move: ");
            }

        if (enemySoldiers <= 0) {
            System.out.println("Game over");
            System.out.println("YOU WIN; all enemy soldiers are dead");
            isGameRunning = false;
        }
    }

    public void playerForward(){
        System.out.println("You chose to: move FORWARD");

        int dice = random.nextInt(6)+1;
        int  move = (dice % 2 == 0) ? 2 : 1;
        if (playerPosition - move >= enemyBaseCamp){
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

        if (playerPosition + move <= playerBaseCamp){
            playerPosition += move;
            playerShots += 250;
            System.out.println("You moved " + move + " fields back");
        } else {
            System.out.println("You can't move any further back");
        }
        System.out.println("Your current position is: " + playerPosition);
    }

    public void playerAttack(){
        System.out.println("You chose to: ATTACK");

        System.out.println("Distance is: " + distance());

        int dice = random.nextInt(6) + 1;
        System.out.println("You rolled a: " + dice);

        int shotValue = dice * 100;
        System.out.println("Shotvalue: " + shotValue);

        if (playerShots >= shotValue) {
            playerShots -= shotValue;
        }

        int soldiersToDie = Math.abs(6 - distance());

        System.out.println("Soldiers to die: " + soldiersToDie);

        if (soldiersToDie > 0 && distance() < 6) {
            enemySoldiers -= soldiersToDie;
            System.out.println("You killed a total of: " + soldiersToDie + " soldiers");
            System.out.println("Enemy now has: " + enemySoldiers + " soldiers");
        } else if (enemySoldiers <= 0) {
            System.out.println("Game over");
            System.out.println("YOU WIN; all enemy soldiers are dead");
            isGameRunning = false;
        } else if (playerShots < shotValue) {
            System.out.println("You do not have enough shots");
        } else {
            System.out.println("You are too far away");
        }
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
        System.out.println("Distance: " + distance());
    }


    public int playerBombPosition(){
        return playerPosition;
    }

    public void playerDetonateBomb(){
        int playerBombPosition = playerBombPosition();
        int playerBombDistance = Math.abs(playerBombPosition - playerPosition);

        if (playerBombDistance >= 6){
            enemySoldiers -= 10;
            System.out.println("You killed 10 enemy soldiers");
        } else if (playerBombDistance > 6 && playerBombPosition() == 10) {
            System.out.println("You win game");
            isGameRunning = false;
        } else if (playerBombDistance < 6) {
            System.out.println("You are not far enough to detonate");
        }
    }


    public void quitGame(){
        System.out.println("You chose to: QUIT GAME");
        System.out.println("You lose :(");
        isGameRunning = false;
    }

    public void enemyStart(){
        int dice = random.nextInt(6)+1;
        System.out.println("\nEnemy rolled a: " + dice);
        enemyPosition += dice;
        System.out.println("Enemy now stands on: " + enemyPosition);
    }

    public void enemyTurn(){
        int dice = random.nextInt(3)+1;
        if (dice == 1){
            enemyForward();
        } else if (dice == 2 ) {
            enemyBack();
        } else if (dice == 3 && distance() < 6){
            enemyAttack();
        }

        if (enemySoldiers <= 0) {
            System.out.println("Game over");
            System.out.println("ENEMY WINS; all player soldiers are dead");
            isGameRunning = false;
        }

    }

    public void enemyForward(){
        System.out.println("\nEnemy chose to: move FORWARD");

        int dice = random.nextInt(6)+1;
        int  move = (dice % 2 == 0) ? 2 : 1;

        if (enemyPosition + move <= playerBaseCamp){
            enemyPosition += move;
            System.out.println("Enemy moved " + move + " fields forward");
        } else {
            System.out.println("Enemy can't move any further forward");
        }
        System.out.println("Enemy current position is: " + enemyPosition);
    }

    public void enemyBack(){
        System.out.println("\nEnemy chose to: move BACK");

        int dice = random.nextInt(6) + 1;
        int move;
        if (dice <= 2) {
            move = 1;
        } else if (dice <= 4) {
            move = 2;
        } else {
            move = 3;
        }

        if (enemyPosition - move >= enemyBaseCamp ||enemyShots <= 400){
            enemyPosition -= move;
            enemyShots += 250;
            System.out.println("Enemy moved " + move + " fields back");
        } else {
            System.out.println("Enemy can't move any further back");
        }
        System.out.println("Enemy current position is: " + enemyPosition);
    }

    public void enemyAttack(){
        System.out.println("\nEnemy chose to: ATTACK");

        System.out.println("Distance is: " + distance());

        int dice = random.nextInt(6) + 1;
        System.out.println("Enemy rolled a: " + dice);

        int shotValue = dice * 100;
        System.out.println("Shotvalue: " + shotValue);

        if (enemyShots >= shotValue) {
            enemyShots -= shotValue;
        }

        int soldiersToDie = Math.abs(6 - distance());

        System.out.println("Soldiers to die: " + soldiersToDie);

        if (soldiersToDie > 0 && distance() < 6) {
            playerSoldiers -= soldiersToDie;
            System.out.println("Enemy killed a total of: " + soldiersToDie + " soldiers");
            System.out.println("Player now has: " + playerSoldiers + " soldiers");
        } else if (playerSoldiers <= 0) {
            System.out.println("Game over");
            System.out.println("ENEMY WIN; all player soldiers are dead");
        } else if (playerShots < shotValue) {
            System.out.println("Enemy do not have enough shots");
        } else {
            System.out.println("Enemy is too far away");
        }
    }

    public int distance(){
        return Math.abs(playerPosition - enemyPosition);
    }


}