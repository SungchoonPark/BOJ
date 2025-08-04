import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> lets = new ArrayList<>();
        List<String> digs = new ArrayList<>();
        String[] result = new String[logs.length];

        for(String log : logs) {
            if(Character.isDigit(log.split(" ")[1].charAt(0))) {
                digs.add(log);
            } else {
                lets.add(log);
            }
        }

        lets.sort((i1, i2) -> {
            String[] s1x = i1.split(" ", 2);
            String[] s2x = i2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);
            if(compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });

        lets.addAll(digs);
        int idx = 0;
        for(int i=0; i<lets.size(); i++) {
            result[i] = lets.get(i);
        }

        return result;
    }

}