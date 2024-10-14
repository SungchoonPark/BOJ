import java.util.*;

class Solution {
    static Map<String, Integer> dir = new HashMap<>();
    static int idx = 27;
    static List<Integer> result = new ArrayList<>();
    
    public int[] solution(String msg) {
        // 알파벳 세팅
        for(char c = 'A'; c <= 'Z'; c++) {
            dir.put(String.valueOf(c), c - 'A' + 1);
        }
        
        int i = 0;
        while(i < msg.length()) {
            String tmp = String.valueOf(msg.charAt(i));
            Integer tmpIdx = dir.get(tmp);
            int j = i + 1;
            
            while(j < msg.length() && dir.containsKey(tmp + msg.charAt(j))) {
                tmp += msg.charAt(j);
                tmpIdx = dir.get(tmp);
                j++;
            }
            
            result.add(tmpIdx);
            
            if(j < msg.length()) {
                dir.put(tmp + msg.charAt(j), idx++);
            }
            
            i = j;
        }
        
        // 결과를 배열로 변환하여 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
