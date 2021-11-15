import java.util.Random;
import java.util.Scanner;

public class Main {

    public Main() {



    }

    public static void main(String[] args) throws InterruptedException {

        //new Main();
        //system objects
        Scanner in = new Scanner(System.in); //accepts input from user
        Random rand = new Random(); // lets us generate random numbers for our game

        //game variables
        //enemy array, holds all enemy types
        String[] enemies = {"Troll", "Skeleton", "Cannibal", "Wolf"};
        int maxEnemyHealth = 50; //max health any of the above enemies can have
        int enemyAttackDamage = 9; // max damage enemies can dish out

        //player variables
        int health = 75; //players health
        int attackDamage = 17; //players attack damage
        int numHealthPots = 2; //players starting amount of health potions
        int healthPotionsHealAmount = 30; //how much health pots will heal for
        int healthPotionDropChance = 50; //percentage of enemies dropping health potions
        int counter = 0;

        boolean running = true; //lets the computer know if the game is still running

        System.out.println("Welcome to an Adventure!"); //welcome message
        Thread.sleep(1200);

        Game: //name/label of while loop, while game is running
        while(running){
            System.out.println("-------------------------------------------------");

            System.out.println("Something is approaching you");
            Thread.sleep(1200);
            System.out.println("You quickly grab your sword and prepare to fight.");
            Thread.sleep(1200);
            System.out.println("-------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth); //gives enemy a random amount of health between 0-75
            String enemy = enemies[rand.nextInt(enemies.length)]; //picks a random enemy out of our enemies array
            System.out.println("\t# "+ enemy +" has appeared! #\n");
            //      #Skeleton has appeared!

            while(enemyHealth > 0) {

                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " +enemyHealth);
                Thread.sleep(1200);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health Potion");
                System.out.println("\t3. Run");

                String input = in.nextLine();
                if(input.equals("1")){
                    int damageDealt = rand.nextInt(attackDamage);// randomizes damageDealt to enemy
                    int damageTaken = rand.nextInt(enemyAttackDamage);// randomizes damageTaken from enemy
                    enemyHealth -= damageDealt;//removes incurred damage on enemy
                    health -= damageTaken;// removes incurred damage from user

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt);
                    System.out.println("\t> You receive " + damageTaken + " from retaliation");

                    if(health < 1) {
                        System.out.println("\t You have taken too much damage, you are too weak to go on");
                        break;
                    }
                }
                else if(input.equals("2")){
                    if(numHealthPots > 0) {
                        health += healthPotionsHealAmount;
                        numHealthPots --;
                        System.out.println("\t You drank a health potion healing yourself for " + healthPotionsHealAmount
                                + "\n\t You now have " + health + " HP."
                                + "\n\t You have " + numHealthPots + " left.");
                    }
                    else {
                        System.out.println("\t You don't have any health potions left, defeat enemies to obtain them.");
                    }
                }
                else if(input.equals("3")){
                    counter++;
                    if(counter > 3){
                        System.out.println("You have tried to run away too many times...");
                        System.out.println("Game Over");
                        break Game;
                    }
                    else
                    System.out.println("You run away from the " + enemy + "!");
                    Thread.sleep(1200);
                    System.out.println("As you continue through the forest you hear rustling in the bushes ");
                    Thread.sleep(1200);
                    //System.out.println("Your view slowly fades to black..");

                    continue Game; // ignores anything below and restarts from main GAME while loop

                }
                else {
                    System.out.println("\t Invalid Command!");
                }

            }
            if(health < 1) {
                System.out.println("You limp out of combat");
                break;
            }

            System.out.println("------------------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + health + " HP left #");
            if(rand.nextInt(100) < healthPotionDropChance){
                numHealthPots++;
                System.out.println(" # The " + enemy + " dropped a health potion # ");
                System.out.println(" # You have " + numHealthPots + " health potion(s). # ");

                System.out.println("-------------------------------------------------------------");
                System.out.println("What would you like to do?");
                System.out.println("1. Continue fighting");
                System.out.println("2. Exit Dungeon");

                String input = in.nextLine();

                while (!input.equals("1") && !input.equals("2") ){
                    System.out.println("Invalid Command!");
                    input = in.nextLine();
                }

                if(input.equals("1")){
                    System.out.println("You continue on your adventure");
                }

                else {
                    System.out.println("You exit the dungeon, successfully.");
                    Thread.sleep(1200);
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Thanks for playing!");
                    break;
                }
            }
        }
    }
}
