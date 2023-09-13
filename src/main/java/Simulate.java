public class Simulate {
    public static void sim(){
        Car[] cars = new Car[100];
        Radarstation primarySchool = new Radarstation(30);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }

        for (Car car:cars) {
            Penalty pen = primarySchool.control(car);
            if (pen.getIsSpeeding()){
                Record.add(car.getNumberplate().toString(), pen);
            }
        }

    }
}
