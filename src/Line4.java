import java.util.Random;
import java.util.Scanner;

public class Line4 {
    public static void main(String[] args) {
        new Line4().run();
    }

    Scanner in = new Scanner(System.in);
    Random random = new Random();


    final int playerBase = 10;
    int playerPosition = 10;
    int playerSoldiers = 25;
    int playerShots = 2500;
    int playerBomb = 1;


    final int enemyBase = -10;
    int enemyPosition = -10;
    int enemySoldiers = 25;
    int enemyShots = 2500;
    int enemyBomb = 1;


    int distance = Math.abs(playerPosition - enemyPosition);


    private void run() {
        welcomeMessage();
        playerStart();
        enemyStart();
        while (enemySoldiers >= 0 || playerPosition >= 0){
            chooseYourMoveNoBomb();
            String answer = in.nextLine();

            if (answer.equalsIgnoreCase("f")){
                playerForward();
            } else if (answer.equalsIgnoreCase("b")) {
                playerMoveBack();
            } else if (answer.equalsIgnoreCase("a")) {
                playerAttack();
            } else if (answer.equalsIgnoreCase("s")) {
                status();
            } else if (answer.equalsIgnoreCase("q")) {
                quitGame();
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
        int playerDice = random.nextInt(6)+1;
        System.out.println("You rolled a: " + playerDice);
        playerPosition -= playerDice;
        System.out.println("You now stand on: " + playerPosition);
    }


    public void enemyStart(){
        int enemyDice = random.nextInt(6)+1;
        System.out.println("Enemy rolled a: " + enemyDice);
        enemyPosition += enemyDice;
        System.out.println("Enemy now stands on: " + enemyPosition);
    }


    public void chooseYourMoveNoBomb(){
        System.out.println();
        System.out.println("Choose your move...");
        System.out.println("Move forward: press f");
        System.out.println("Move back: press b");
        System.out.println("Attack: press a");
        System.out.println("Status: press s");
        System.out.println("Quit game: press q");
        System.out.println();
    }





    public void playerForward(){
        int dice = random.nextInt(6)+1;
        if (dice % 2 == 0){
            playerPosition -= 2;
            System.out.println();
            System.out.println("You moved two fields");
            System.out.println("Your current position is: " + playerPosition);
            System.out.println();
        } else {
            playerPosition -= 1;
            System.out.println();
            System.out.println("You moved one field");
            System.out.println("Your current position is: " + playerPosition);
            System.out.println();
        }}

    public void enemyForward(){
        int dice = random.nextInt(6)+1;
        if (dice % 2 == 0){
            enemyPosition += 2;
            System.out.println();
            System.out.println("Enemy moved two fields");
            System.out.println("Enemy current position: " + enemyPosition);
        } else {
            enemyPosition += 1;
            System.out.println();
            System.out.println("Enemy moved one field");
            System.out.println("Enemy current position: " + enemyPosition);
            System.out.println();
        }}




    public void playerMoveBack(){
        int dice = random.nextInt(6)+1;
        if (dice == 1 || dice == 2){
            playerPosition += 1;
            System.out.println("You moved one field");
            System.out.println("Your current position is: " + playerPosition);
        } else if (dice == 3 || dice == 4) {
            playerPosition += 2;
            System.out.println("You moved two fields");
            System.out.println("Your current position is: " + playerPosition);
        } else {
            playerPosition += 3;
            System.out.println("You moved three fields");
            System.out.println("Your current position is: " + playerPosition);
        }

        playerShots += 250;

        if (playerPosition == 10 && playerBomb == 0){
            playerBomb = 1;
        }
    }

    public void enemyMoveBack(){
        int dice = random.nextInt(6)+1;
        if (dice == 1 || dice == 2){
            enemyPosition -= 1;
            System.out.println("You moved one field");
            System.out.println("Your current position is: " + enemyPosition);
        } else if (dice == 3 || dice == 4) {
            enemyPosition -= 2;
            System.out.println("You moved two fields");
            System.out.println("Your current position is: " + enemyPosition);
        } else {
            enemyPosition -= 3;
        }

        enemyShots += 250;

        if (enemyPosition == 10 && enemyBomb == 0){
            enemyBomb = 1;
        }
    }



    public void playerAttack(){

        int distance = Math.abs(playerPosition - enemyPosition);

        int dice = random.nextInt(6)+1;
        System.out.println("You rolled a: " + dice);
        int shotValue;

        if (dice == 1){
            shotValue = 100;
        } else if (dice == 2) {
            shotValue = 200;
        } else if (dice == 3) {
            shotValue = 300;
        } else if (dice == 4) {
            shotValue = 400;
        } else if (dice == 5) {
            shotValue = 500;
        } else {
            shotValue = 600;
        }
        System.out.println("Shot value: " + shotValue);

        if (playerShots >= shotValue){
            playerShots -= shotValue;
        }

        int soldiersToDie = 6 - distance;

        System.out.println("Soldiers to die: " + soldiersToDie);

        if (soldiersToDie > 0){
            enemySoldiers -= soldiersToDie;
            System.out.println("You killed a total of: " + soldiersToDie + " soldiers");
            System.out.println("Enemy now has: " + enemySoldiers + " soldiers");
        }
        if (enemySoldiers <= 0){
            System.out.println("Game over");
            System.out.println("YOU WIN; all enemy soldiers are dead");
        } else {
            System.out.println("You do not have enough shots");
        }
    }


    public void enemyAttack(){
        int dice = random.nextInt(6)+1;
        int shotValue = 0;

        if (dice == 1){
            shotValue = 100;
        } else if (dice == 2) {
            shotValue = 200;
        } else if (dice == 3) {
            shotValue = 300;
        } else if (dice == 4) {
            shotValue = 400;
        } else if (dice == 5) {
            shotValue = 500;
        } else {
            shotValue = 600;
        }

        if (enemyShots >= shotValue){
            enemyShots -= shotValue;
        }
        int soldiersToDie = 6 - distance;
        if (soldiersToDie > 0){
            playerSoldiers -= soldiersToDie;
            System.out.println("Enemy killed a total of: " + soldiersToDie + " soldiers");
            System.out.println("Player now has: " + playerSoldiers + " soldiers");
        }
        if (playerSoldiers <= 0){
            System.out.println("Game over");
            System.out.println("YOU LOSE; all your soldiers are dead");
        } else {
            System.out.println("Enemy did not have enough shots");
        }
    }



    public void status(){
        System.out.println("Status:");
        System.out.println();
        System.out.println("Player SHOTS remaining: " + playerShots );
        System.out.println("Enemy SHOTS remaining: " + enemyShots );
        System.out.println();
        System.out.println("Player SOLDIERS remaining: " + playerSoldiers);
        System.out.println("Enemy SOLDIERS remaining: " + enemySoldiers);
        System.out.println();
        System.out.println("Player BOMB remaining: " + playerBomb);
        System.out.println("Enemy BOMB remaining: " + enemyBomb);
        System.out.println();
        System.out.println("Player POSITION: " + playerPosition);
        System.out.println("Enemy POSITION: " + enemyPosition);
        System.out.println();
        System.out.println("Player and Enemy DISTANCE: " + distance);
    }



    public void quitGame(){

    }



    public void chooseYourMoveWithBomb(){
        System.out.println("Choose your move...");
        System.out.println("Move forward: press f");
        System.out.println("Move back: press b");
        System.out.println("Attack: press a");
        System.out.println("Place bomb: press p");
        System.out.println("Detonate bomb: press d");
        System.out.println("Status: press s");
        System.out.println("Quit game: press q");
    }




    public void playerPlaceBomb(){
        if (playerPosition >= -10 && playerPosition <= -1){

        }
    }

    public void enemyPlaceBomb() {
        if (enemyPosition <= 10 && enemyPosition >= 1) {

        }
    }





    public void playerDetonateBomb() {
    }


    public void enemyDetonateBomb() {
    }




}
