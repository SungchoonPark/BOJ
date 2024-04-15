import java.util.*;
class Solution {
    public String solution(String phone_number) {
        int end = phone_number.length() - 4;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<end; i++) {
            sb.append("*");
        }
        for(int i=end; i<phone_number.length(); i++) {
            sb.append(phone_number.charAt(i));
        }
        return sb.toString();
    }
}