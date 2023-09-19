public class Line2 {
    public static void main(String[] args) {
        new Line2().run();

        System.out.println("Welcome; press to roll dice and move tiles");
        // Scanner
        // Random
        //


        System.out.println("What do you wish to do?");

        System.out.println("Move foward: press f");
        // Terning; lige tal = 2 felter frem / ulige tal = 1 felt frem

        System.out.println("Move back: press b");
        // Terning; 1-2 = 1 felt / 3-4 = 2 felter / 5-6 = 3 felter
        // For hver et felt man trækker tilbage modtager man 250 flere skud
        // Hvis du lander i din base (-10 eller 10) så får man en bombe (hvis man ikke har en)

        System.out.println("Attack: press a");
        // Terning; 1 = 100 skud (ud fra ens 2500 (så den skal minusse)) 2 = 200 skud ... 6 = 600 skud
        // Ikke muligt at skyde hvis man ikke har nok antal skud
        // Skal recognize hvor fjenden er, hvis fjende står på samme felt så
        // 0 felter væk = 6 soldater dør (af hans 25 (man skal minus igen),
        // 1 felt væk = 5 soldater dør ... osv

        // if (soldiers <= 0;) {
        //     sout ("You lose")
        // }


        System.out.println("Status: press s");
        // Få status på en selv og på fjende
        // Hvor mange skud er der tilbage?
        // Hvor mange soldater er der tilbage?
        // Bomben ????
        // Hvor befinder man sig på felterne?

        System.out.println("Quit game: press q");
        // Afslut spil; modstander vinder



        // Det her skal først dukke op når/hvis
        // Kun muligt når man ikke er i eget territory + modstanderen også skal være i deres eget territory

        System.out.println("Place bomb: press p");
        // Kun muligt når man ikke er i eget territory + modstanderen også skal være i deres eget territory

        System.out.println("Detonate bomb: press d");
        // Du skal være 6 felter væk fra bomben
        // Hvis du detonere bomben ved opponents base camp (-10 eller 10) = så vinder man spillet




    }




    private void run() {
        int sum = 0;

        for (int i = 1; i <= 33; i++){
            sum = sum + i;
            System.out.println();
        }

        {
            System.out.println("Sum: " + sum);
        }

    }



    public void playerAttack() {
        System.out.println("You chose to: ATTACK");
     //   if (playerShots >= 250) {
            // Deduct shots and perform the attack logic
     //       playerShots -= 250;

            // Determine the enemy's proximity (for example, assume enemyPosition is the enemy's position)
      //      int proximity = Math.abs(playerPosition - enemyPosition);

            // Calculate the number of enemy soldiers that die based on proximity
    //        int soldiersDied = 6 - proximity;

      //      if (soldiersDied > 0) {
     //           System.out.println(soldiersDied + " enemy soldiers died due to your attack!");
                // Deduct enemy soldiers or perform other relevant actions
      //      } else {
                System.out.println("Your attack missed!");
            }
     //   } else {
     //       System.out.println("You don't have enough shots for an attack.");
   //     }
 //   }

    public void enemyAttack() {
        // Implement enemy attack logic here
        // For example, you can use a similar random chance of success

        // Determine the player's proximity (for example, assume playerBaseCamp is the player's base camp position)
       // int proximity = Math.abs(playerPosition - playerBaseCamp);

        // Calculate the number of player soldiers that die based on proximity
       /// int soldiersDied = 6 - proximity;

      //  if (soldiersDied > 0) {
      //      System.out.println(soldiersDied + " of your soldiers died in the enemy's attack!");
            // Deduct player soldiers or perform other relevant actions
      //  } else {
            System.out.println("The enemy's attack missed!");
        }
    }









// lav en distance hvor det er med playerposition og bombposition, og den skal så være (distance) > 6 for at
// den spørger om du vil detonate + enemyposition skal også være mellem -1 og 10 for at du kan placere bombe
// + hvis man udløser bomben ved -10 (enemybase) så vinder du


