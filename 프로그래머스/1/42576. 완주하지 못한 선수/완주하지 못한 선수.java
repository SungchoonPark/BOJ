import java.util.*;
class Solution {
    private static Map<String, Integer> map = new HashMap<>();
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        for(String p : participant) {
            map.putIfAbsent(p, 0);
            map.put(p, map.get(p) + 1);
        }
        
        for(String p : completion) {
            int cnt = map.get(p);
            if(cnt == 1) {
                map.remove(p);
            } else {
                map.put(p, map.get(p) - 1);
            }
        }
        Set<String> keySet = map.keySet();
        String result = null;
        for(String r : keySet) {
            System.out.println(r);
            result = r;
        }
        return result;
    }
}