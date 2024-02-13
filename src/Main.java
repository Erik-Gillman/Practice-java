
import java.util.Random;
import java.util.Scanner;

public class Main {
    public enum choices{
        ROCK,
        PAPER,
        SCISSORS
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int userChoice;
        char cont = 'y';
        final char QUIT = 'n';
        System.out.println("Let's play a game of rock paper scissors");
        do{
            System.out.print("Rock = " + choices.ROCK.ordinal() + ", Paper = " + choices.PAPER.ordinal() + ", Scissors = " +
                                choices.SCISSORS.ordinal() + ": ");
            try{
                userChoice = Integer.parseInt(scanner.nextLine());
            }
            catch(NumberFormatException notDigits){
                System.out.println("Do not enter non digit values");
                continue;
            }
            if(userChoice < choices.ROCK.ordinal() || userChoice > choices.SCISSORS.ordinal()){
                System.out.println("Please enter a value between " + choices.ROCK.ordinal() +
                        " and " + choices.SCISSORS.ordinal() + ".");
                continue;
            }
            choices play = choices.values()[userChoice];
            int randNum = rand.nextInt(3);
            switch (play) {
                case ROCK -> {
                    if (randNum == choices.ROCK.ordinal()) {
                        System.out.println("You tie");
                    } else if (randNum == choices.PAPER.ordinal()) {
                        System.out.println("They picked paper. You lose");
                    } else {
                        System.out.println("They picked scissors. You win");
                    }
                }
                case PAPER -> {
                    if (randNum == choices.ROCK.ordinal()) {
                        System.out.println("They picked rock. You win");
                    } else if (randNum == choices.PAPER.ordinal()) {
                        System.out.println("You tie");
                    } else {
                        System.out.println("They picked scissors. You lose");
                    }
                }
                case SCISSORS -> {
                    if (randNum == choices.ROCK.ordinal()) {
                        System.out.println("They picked rock. You lose");
                    } else if (randNum == choices.PAPER.ordinal()) {
                        System.out.println("They picked paper. You win");
                    } else {
                        System.out.println("You tie");
                    }
                }
                default -> System.out.println("Invalid choice");
            }
            System.out.print("Enter " + QUIT + " to quit or any other key to continue: ");
            cont = scanner.nextLine().charAt(0);
        }while(cont!='n');
    }
}