import java.util.Random;

public class Jar {
    private int numberOfitems ;
    private int maxNumberOfItems;
    private String type ;

    public Jar(String type , int maxNumberOfItems){
        this.type = type ;
        this.maxNumberOfItems = maxNumberOfItems;
    }


    public void fill(){
        Random random = new Random();
        numberOfitems = random.nextInt(maxNumberOfItems) + 1 ;
    }

    public boolean applyGuess(int x){
        if(x>maxNumberOfItems){
            throw new IllegalArgumentException("Your guess is too high");
        }else if (x<1){
            throw new IllegalArgumentException("Your guess is too low");
        }
        if(x == numberOfitems){
            return true ;
        }
        else {
            return false;
        }
    }


    public int getNumberOfitems() {
        return numberOfitems;
    }

    public int getMaxNumberOfItems() {
        return maxNumberOfItems;
    }

    public String getType() {
        return type;
    }
}
