import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> maps = new HashMap<>();
        
        for(String p : participant) {
            maps.put(p, maps.getOrDefault(p, 0) + 1);
        }
        
        
        for(String p : completion) {
            int count = maps.get(p);
            
            if(count - 1 == 0) {
                maps.remove(p);
                continue;
            }
            
            maps.put(p, count - 1);
        }
                
        for(String p : maps.keySet()) {
            return p;
        }
        
        return "EMPTY";
    }
}