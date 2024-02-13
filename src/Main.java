
import java.util.Scanner;

public class Main {
    public enum choices{
        ROCK,
        PAPER,
        SCISSORS
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            switch (play) {
                case ROCK -> System.out.println("You lost");
                case PAPER -> System.out.println("Tie");
                case SCISSORS -> System.out.println("You win");
                default -> System.out.println("Invalid choice");
            }
            System.out.print("Enter " + QUIT + " to quit or any other key to continue: ");
            cont = scanner.nextLine().charAt(0);
        }while(cont!='n');
    }
}