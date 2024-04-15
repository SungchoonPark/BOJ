import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(n);
        List<Integer> list = new ArrayList<>();
        
        for(String str : s.split("")) {
            list.add(Integer.parseInt(str));
        }
        
        Collections.sort(list);
        for(Integer i : list) {
            sb.append(i);
        }
        return Long.parseLong(sb.reverse().toString());
    }
}