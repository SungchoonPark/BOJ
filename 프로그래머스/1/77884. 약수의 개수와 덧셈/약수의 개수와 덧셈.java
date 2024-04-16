import java.util.*;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++) {
            System.out.println(getNum(i));
            if(getNum(i) % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
    
    private int getNum(int n) {
        int tmp = 1;
        for(int i=1; i<=n/2 ;i++) {
            if(n % i ==0) tmp++;
        }
        return tmp;
    }
}