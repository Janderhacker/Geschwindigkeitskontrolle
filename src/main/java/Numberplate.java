public class Numberplate {
    Randomwrapper charGen = new Randomwrapper();
    private final char[] Numberplate = new char[7];
    public Numberplate(){
        Numberplate[0] = '[';
        for(int i = 1; i <6; i++){
            Numberplate[i] = charGen.getRandomChar();
        }
        Numberplate[6] = ']';
    }

    public char[] getNumberplate() {
        return Numberplate;
    }
}
