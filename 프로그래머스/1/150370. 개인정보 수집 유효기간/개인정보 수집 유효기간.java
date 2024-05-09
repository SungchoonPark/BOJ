import java.util.*;
import java.time.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String[] day = today.split("\\.");
        LocalDate tday = LocalDate.of(Integer.parseInt(day[0]), Integer.parseInt(day[1]), Integer.parseInt(day[2]));
        
        for(String t : terms) {
            String[] s = t.split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }
        
        for(int i=0; i<privacies.length; i++) {
            String s = privacies[i];
            String[] tmp = s.split(" ");
            
            String type = tmp[1];
            String[] date = tmp[0].split("\\.");
            int years = Integer.parseInt(date[0]);
            int months = Integer.parseInt(date[1]);
            int days = Integer.parseInt(date[2]);
            LocalDate tmpDay;
            if(days - 1 == 0) {
                if(months - 1 == 0) {
                    years--;
                    months = 12;
                } else {
                    months--;
                }
                tmpDay = LocalDate.of(years, months, 28);
            } else {
                tmpDay = LocalDate.of(years, months, days - 1);
            }
            
            LocalDate testDay = tmpDay.plusMonths(map.get(type));
            if(tday.isAfter(testDay)) list.add(i + 1);
        }
        Collections.sort(list, (s1, s2) -> s1 - s2);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}