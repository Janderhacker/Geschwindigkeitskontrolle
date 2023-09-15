import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.StringJoiner;

public class Penalty{
    private final int v;
    private final int v_tol;
    private final Date date;
    private boolean isSpeeding = false;

    private int fine; //in €
    private int drivingBan; //in days


    public Penalty(int v, int v_max){
        this.v = v;
        int toleranz = 3;
        this.v_tol = v - v_max - toleranz;

        Calendar startDate = new GregorianCalendar(2000, Calendar.JANUARY, 1);
        Calendar endDate = new GregorianCalendar();

        Randomwrapper rw = new Randomwrapper();
        this.date = rw.generateRandomDate(startDate.getTime(), endDate.getTime());
        //this.date = new Date();

        evalPenalty();
    }
    // Richtige Strafe bestimmen
    private void evalPenalty(){
        this.drivingBan = 0;
        if (v_tol < 1){
            this.fine = 0;
            isSpeeding = false;
            return;
        }
        isSpeeding = true;

        if (v_tol <= 10) fine = 30;
        if (v_tol >= 11 && v_tol <= 15) fine = 50;
        if (v_tol >= 16 && v_tol <= 20) fine = 70;
        if (v_tol >= 21 && v_tol <= 25) fine = 115;
        if (v_tol >= 26){
            fine = v_tol * 50;
            drivingBan = v_tol;
        }

    }

    public boolean getIsSpeeding() {
        return isSpeeding;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd.MM.yyyy HH:mm:ss");
        StringJoiner builder = new StringJoiner(", ");
        builder.add(simpleDateFormat.format(date));
        builder.add(v + " km/h");
        builder.add(fine + " €");
        if (drivingBan > 0) builder.add(drivingBan + " Tage Fahrverbot");
        return builder.toString();
    }

    public int getV() {
        return v;
    }

    public Date getDate() {
        return date;
    }



    public int getDrivingBan() {
        return drivingBan;
    }

    public int getFine() {
        return fine;
    }
}
