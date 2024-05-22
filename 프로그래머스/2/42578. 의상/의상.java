import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] s : clothes) {
            map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }
        int result = 1;
        
        for(Integer i : map.values()) {
            result = result * (i+1);
        }
        
        return result-1;
    }
}