import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        String[] strs = String.valueOf(n).split("");
        Arrays.sort(strs);
        for(String s : strs) {
            sb.append(s);
        }
        
        return Long.parseLong(sb.reverse().toString());
    }
}