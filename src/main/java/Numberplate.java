public class Numberplate {
    Randomwrapper charGen = new Randomwrapper();
    private final char[] numberplate = new char[7];
    public Numberplate(){
        numberplate[0] = '[';
        for(int i = 1; i <6; i++){
            numberplate[i] = charGen.getRandomChar();
        }
        numberplate[6] = ']';
    }

    public char[] getNumberplate() {
        return numberplate;
    }

    @Override
    public String toString() {
        return new String(numberplate);
    }
}
