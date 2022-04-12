import java.util.HashMap;
import java.util.Map;

public class WeekDays {

    public static void main(String[] args) {
        System.out.println(weekDays("Wed", 3));
    }

    private static String weekDays(String day, int num) {
        Map<String, Integer> days = new HashMap<>(7);

        days.put("Mon", 1);
        days.put("Tue", 2);
        days.put("Wed", 3);
        days.put("Thu", 4);
        days.put("Fri", 5);
        days.put("Sat", 6);
        days.put("Sun", 7);

        Integer currentDay = days.get(day);
        Integer newDay = (currentDay + num)%7;
        return days.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(newDay))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");
    }
}
