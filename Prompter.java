import java.util.Scanner;
public class Prompter {
    private Scanner scanner = new Scanner(System.in);
    private Jar jar;
    private boolean isHit;

    public Prompter(){
        System.out.println("Set the type of items in the jar");
        String type = scanner.nextLine();
        System.out.println("Set the maximum number of items in the jar");
        int maxNumb = scanner.nextInt();
        jar = new Jar(type , maxNumb);

    }

    public void promptForGuess(){
        int numberOfGuesses = 0 ;
        do{
            displayMaxNumberAndType();
            displayNumberToGuess();
            System.out.printf("Pick a number between 1 and %d %n%n" , jar.getMaxNumberOfItems());
            int guess = scanner.nextInt();
            try{
               isHit = jar.applyGuess(guess);

               if(isHit){
                    numberOfGuesses++;
                    System.out.printf("Congratulations , you got it in %d trie(s)" , numberOfGuesses);
                }
                numberOfGuesses++;

            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                System.out.printf("You must pick a number between 1 and %d %n%n" , jar.getMaxNumberOfItems());
            }
        }while(!isHit);


    }




    private void displayMaxNumberAndType(){
        System.out.printf("The maximum number of %s in the jar is %d %n%n" , jar.getType() , jar.getMaxNumberOfItems());
    }
    private void displayNumberToGuess(){
        System.out.printf("The number to guess is %d %n%n" , jar.getNumberOfitems());
    }

    public Jar getJar() {
        return jar;
    }
}
