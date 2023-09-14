public class Radarstation {
    private final int vmax;
    public Radarstation(int _vmax){
        vmax = _vmax;
    }

    public Penalty control(Car car){
        return new Penalty(car.getSpeed(), this.vmax);
    }
}
