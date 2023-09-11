public class Car {
    private final char[][] carfront = new char[35][17];
    private final Numberplate numberplate = new Numberplate();
    Randomwrapper charGen = new Randomwrapper();
    public Car(){
        for(int i = 0; i < 35; i++){
            for(int j = 0; j < 17; j++){
                carfront[i][j] = charGen.getRandomChar();
            }
        }


    }



    public char[][] getCarfront() {
        return carfront;
    }
}
