import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, (v1, v2) -> v2 - v1);
        for(Integer v : list) {
            k -= v;
            answer++;
            if(k <= 0) break;
        }
        
        
        return answer;
    }
}