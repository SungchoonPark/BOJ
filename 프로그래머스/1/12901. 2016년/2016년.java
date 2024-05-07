import java.util.*;
import java.time.*;
class Solution {
    public String solution(int a, int b) {
        DayOfWeek day = LocalDate.of(2016, a, b).getDayOfWeek();
        String tmp = String.valueOf(day);
        if(tmp.equals("MONDAY")) return "MON";
        else if(tmp.equals("TUESDAY")) return "TUE";
        else if(tmp.equals("WEDNESDAY")) return "WED";
        else if(tmp.equals("THURSDAY")) return "THU";
        else if(tmp.equals("FRIDAY")) return "FRI";
        else if(tmp.equals("SATURDAY")) return "SAT";
        else return "SUN";
    }
}