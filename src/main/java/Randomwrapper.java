import java.util.Random;

public class Randomwrapper {
    Random r = new Random();
    String randomValue = "0123456789abcdefghijklmnopqrstuvwxyz";

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

    char getRandomChar(){
        return randomValue.charAt(r.nextInt(randomValue.length()));
    }

    int getRandomSpeed(){
        if(r.nextInt(10)==1){
            return r.nextInt(26)+35;
        }
        else{
            return 30;
        }
    }
}
