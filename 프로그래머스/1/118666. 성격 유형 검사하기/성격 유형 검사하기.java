import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        String[] strs = {"R", "T", "C", "F", "J", "M", "A", "N"};
        for(int i=0; i<strs.length; i++) {
            map.put(strs[i], 0);
        }
        
        for(int i=0; i<survey.length; i++) {
            String[] tmp = survey[i].split("");
            String type1 = tmp[0];
            String type2 = tmp[1];
            
            int num = choices[i];
            int score = 0;
            if(num <= 3) {
                if(num == 1) score = 3;
                else if(num == 2) score = 2;
                else score = 1;
                map.put(type1, map.get(type1) + score);
            } else if(num >= 5) {
                score = num - 4;
                map.put(type2, map.get(type2) + score);
            }
        }
        
        for(int i=0; i<4; i++) {
            int tmp1 = map.get(strs[i*2]);
            int tmp2 = map.get(strs[i*2 + 1]);
            if(tmp1 > tmp2) sb.append(strs[i*2]);
            else if(tmp1 < tmp2) sb.append(strs[i*2 + 1]);
            else {
                int a = strs[i*2].compareTo(strs[i*2+1]);
                if(a < 0) sb.append(strs[i*2]);
                else sb.append(strs[i*2+1]);
            };
        }
        
        return sb.toString();
    }
}