import java.util.Random;

public class Randomwrapper {
    Random r = new Random();
    String randomValue = "0123456789abcdefghijklmnopqrstuvwxyz";

    Postion getRandomPosition(){
        switch (r.nextInt(3)) {
            case 1 -> {
                return Postion.LEFT;
            }
            case 2 -> {
                return Postion.MIDDLE;
            }
            case 3 -> {
                return Postion.RIGHT;
            }
        }
    }

    char getRandomChar(){
        return randomValue.charAt(r.nextInt(randomValue.length()));
    }

}
