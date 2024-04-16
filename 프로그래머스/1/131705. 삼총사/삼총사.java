import java.util.*;
class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int len = number.length;
        for(int i=0; i<len-2; i++){
            int a = number[i];
            for(int j=i+1; j < len - 1; j++) {
                int b = number[j];
                for(int k=j+1; k < len; k++) {
                    int c = number[k];
                    if(a + b + c == 0) answer++;
                }
            }
        }
        
        return answer;
    }
}