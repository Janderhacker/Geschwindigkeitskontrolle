import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Tui {
    public Tui() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        boolean running = true;
        while (running) {
            System.out.println("*---------------------------------------------*");
            System.out.println("| 1.) Show all records                        |");
            System.out.println("| 2.) Show all records in a time range        |");
            System.out.println("| 3.) Show all records above a specific speed |");
            System.out.println("| 4.) Clear all records                       |");
            System.out.println("| 5.) Simulate                                |");
            System.out.println("| 6.) Exit                                    |");
            System.out.println("*---------------------------------------------*");
            System.out.print("a: ");
            try {
                menu = scanner.nextInt();
            }
            catch (Exception e){
                System.out.println("Fehler: " + e);
            }
            switch (menu) {
                case 1 -> Record.printAll();
                case 2 -> {
                    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                    System.out.print("Enter from Date (dd.MM.yyyy): ");
                    String from = scanner.next();
                    System.out.print("Enter to Date (dd.MM.yyyy): ");
                    String to = scanner.next();

                    Date toDate = df.parse(to);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(toDate);
                    calendar.set(Calendar.HOUR_OF_DAY, 23);
                    calendar.set(Calendar.MINUTE, 59);
                    calendar.set(Calendar.SECOND, 59);
                    calendar.set(Calendar.MILLISECOND, 0);

                    Record.printAll(df.parse(from), calendar.getTime());
                }
                case 3 -> {
                    System.out.print("min speed in km/h: ");
                    int v = scanner.nextInt();
                    Record.printAll(v);
                }
                case 4 -> Record.clear();
                case 5 -> {
                    System.out.print("Simulating 100 Cars ... ");
                    Simulate.sim();
                    System.out.println("done");
                }
                case 6 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Bad Input!");
            }
        }
    }
}
