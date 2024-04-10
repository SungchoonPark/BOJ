import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s, " ", true);
        
        while(st.hasMoreTokens()) {
            String tmp = st.nextToken();
            for(int i=0; i<tmp.length(); i++) {
                char c = tmp.charAt(i);
                if(i == 0 && !Character.isDigit(c) && Character.isLowerCase(c)) {
                    c = Character.toUpperCase(c);
                }
                if(i != 0 && Character.isUpperCase(c)) {
                    c = Character.toLowerCase(c);
                }
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}