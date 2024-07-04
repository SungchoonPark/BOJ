import java.util.*;
class Solution {
    public String solution(String number, int k) {
        // number중 k개를 지웠을 때 
        StringBuilder answer = new StringBuilder("");
        int len = number.length() - k;
        int start = 0;
        
        while(start < number.length() && answer.length() != len) {
            int leftNum = k + answer.length() + 1;
            int max = 0;
            for(int i=start; i<leftNum; i++) {
                if(max < number.charAt(i) - '0') {
                    max = number.charAt(i) - '0';
                    start = i + 1;
                }
            }
            answer.append(max);
        }
        
        return answer.toString();
    }
}