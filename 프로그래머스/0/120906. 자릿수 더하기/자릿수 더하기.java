import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] tmp = String.valueOf(n).split("");
        for(String s : tmp) {
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}