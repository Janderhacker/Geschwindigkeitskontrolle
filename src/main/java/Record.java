import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Record {
    private static Map<String, Penalty> penaltyMap = new HashMap<>();
    private static Map<String, Penalty> matchedList = new HashMap<>();

    public static void add(String licence, Penalty pen){
        penaltyMap.put(licence, pen);
    }

    public static void printAll(){
        //copy by value
        matchedList = new HashMap<>(penaltyMap);
        print();
    }

    public static void printAll(int v){
        for (Map.Entry<String, Penalty> entry : penaltyMap.entrySet()) {
            if (entry.getValue().getV() >= v){
               matchedList.put(entry.getKey(), entry.getValue());
            }
        }
        print();
    }

    public static void printAll(Date from, Date to){
        for (Map.Entry<String, Penalty> entry : penaltyMap.entrySet()) {
            Date date = entry.getValue().getDate();
            if (date.after(from) && date.before(to)) {
                matchedList.put(entry.getKey(), entry.getValue());
            }
        }
        print();
    }

    public static void clear(){
        penaltyMap.clear();
    }

    public static Penalty getPenalty(String license){
        return penaltyMap.get(license);
    }

    private static boolean checkEmpty(){
        if (matchedList.isEmpty()){
            System.out.println("No Records.");
            return true;
        }
        return false;
    }

    private static void print() {
        if (checkEmpty()) return;
        for (Map.Entry<String, Penalty> entry : matchedList.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
        matchedList.clear(); //??
    }


}
