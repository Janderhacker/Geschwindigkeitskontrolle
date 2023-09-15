import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class Test {
    //test2 / 3
    Radarstation blitzer = new Radarstation(30);
    Car speedingCar = new Car(60);
    Penalty pen = blitzer.control(speedingCar);

    @org.junit.jupiter.api.Test
    public void testCorrectNumberplate() {
        Car[] cars = new Car[100];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
        }
        Pattern pattern = Pattern.compile("\\[([a-z]|[0-9]){5}\\]");
        for (Car car:cars){
            String NumberplateLine = new String(car.getCarfront()[33]);
            Matcher matcher = pattern.matcher(NumberplateLine);
            assertTrue(matcher.find());
        }
    }

    //beispielsweise Geschwindigkeit von 60 km/h
    // ► Überschreitung nach Abzug Toleranz = 27 km/h
    // ► 27 Tage Fahrverbot, 1350 € Bußgeld.
    @org.junit.jupiter.api.Test
    public void testFine60kmh(){
        if (pen.getIsSpeeding()){
            assertEquals(27, pen.getDrivingBan());
            assertEquals(1350, pen.getFine());
        }
    }

    @org.junit.jupiter.api.Test
    public void testHashtable(){
        String plate = speedingCar.getNumberplate().toString();
        Record.add(plate, pen);
        assertEquals(pen, Record.getPenalty(plate));
    }
}
