public class Car {
    private final int speed;
    private final char[][] carfront = new char[35][17];
    private final Numberplate numberplate = new Numberplate();
    Randomwrapper randomGen = new Randomwrapper();
    public Car(){
        for(int i = 0; i < 35; i++){
            for(int j = 0; j < 17; j++){
                carfront[i][j] = randomGen.getRandomChar();
            }
        }
        switch(randomGen.getRandomPosition()){
            case LEFT -> {
                for(int i = 0; i < 7; i++){
                    carfront[33][i] = numberplate.getNumberplate()[i];
                }
            }
            case MIDDLE -> {
                for(int i = 0; i < 7; i++){
                    carfront[33][i+2] = numberplate.getNumberplate()[i];
                }
            }
            case RIGHT -> {
                for(int i = 0; i < 7; i++){
                    carfront[33][i+4] = numberplate.getNumberplate()[i];
                }
            }
        }
        speed = randomGen.getRandomSpeed();
    }


    public Car(int speed){
        for(int i = 0; i < 35; i++){
            for(int j = 0; j < 17; j++){
                carfront[i][j] = randomGen.getRandomChar();
            }
        }
        switch(randomGen.getRandomPosition()){
            case LEFT -> {
                for(int i = 0; i < 7; i++){
                    carfront[33][i] = numberplate.getNumberplate()[i];
                }
            }
            case MIDDLE -> {
                for(int i = 0; i < 7; i++){
                    carfront[33][i+2] = numberplate.getNumberplate()[i];
                }
            }
            case RIGHT -> {
                for(int i = 0; i < 7; i++){
                    carfront[33][i+4] = numberplate.getNumberplate()[i];
                }
            }
        }
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public char[][] getCarfront() {
        return carfront;
    }

    public Numberplate getNumberplate() {
        return numberplate;
    }
}
