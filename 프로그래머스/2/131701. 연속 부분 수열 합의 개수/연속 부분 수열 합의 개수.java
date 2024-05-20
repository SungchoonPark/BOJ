import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        
        for(int i=1; i<=elements.length; i++) {
            int start = 0;
            int sum = 0;
            while(true) {
                for(int j=0; j<i; j++) {
                    int tmp = start + j;
                    if(tmp >= elements.length) {
                        tmp = tmp % elements.length;
                    }
                    sum += elements[tmp];
                }
                answer.add(sum);
                start++;
                sum = 0;
                
                if(start > elements.length) break;
            }
        }
        
        return answer.size();
    }
}