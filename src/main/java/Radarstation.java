public class Radarstation {
    private final int vmax;
    //Radarstation mit bestimmter Geschwindigkeit erstellen
    public Radarstation(int _vmax){
        vmax = _vmax;
    }
    //Strafe für auto zurückgeben
    public Penalty control(Car car){
        return new Penalty(car.getSpeed(), this.vmax);
    }
}
