import java.util.Date;
import java.util.Random;

public class Randomwrapper {
    Random r = new Random();
    String randomValue = "0123456789abcdefghijklmnopqrstuvwxyz";
    //Zufällige Postion links,mitte,rechts zurückgeben
    Postion getRandomPosition(){
        switch (r.nextInt(3)) {
            case 0 -> {
                return Postion.LEFT;
            }
            case 1 -> {
                return Postion.MIDDLE;
            }
            case 2 -> {
                return Postion.RIGHT;
            }
        }
        return null;
    }
    //Zufälligen char aus randomValue zurückgeben
    char getRandomChar(){
        return randomValue.charAt(r.nextInt(randomValue.length()));
    }
    //Zufällige Geschwindigkeit zurückgeben
    int getRandomSpeed(){
        if(r.nextInt(10)==1){
            return r.nextInt(26)+35;
        }
        else{
            return 30;
        }
    }
    //Zufälliges Datum zurückgeben
    public Date generateRandomDate(Date startDate, Date endDate) {
        long startMillis = startDate.getTime();
        long endMillis = endDate.getTime();

        // Get a random time between startMillis and endMillis
        long randomMillis = startMillis + (long) (Math.random() * (endMillis - startMillis));

        // Create a new Date object from the random time
        return new Date(randomMillis);
    }
}
