import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        for(int i=citations.length-1; i>-1; i--) {
            int min = Math.min(citations[i], citations.length - i);
            if(answer < min) answer = min;
        }
        
        return answer;
    }
}