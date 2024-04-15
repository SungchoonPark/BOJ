import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        if(len % 2 == 0) {
            sb.append(s.charAt(len / 2 - 1)).append(s.charAt(len / 2));
        } else {
            sb.append(s.charAt((len - 1) / 2));
        }
        return sb.toString();
    }
}