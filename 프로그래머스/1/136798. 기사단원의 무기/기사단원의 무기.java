import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++) {
            int tmp = get(i);
            if(tmp > limit) {
                answer += power;
                continue;
            }
            answer += tmp;
        }
        return answer;
    }
    
    private int get(int n) {
        int cnt = 1;
        for(int i=1; i<= n / 2; i++) {
            if(n % i == 0) cnt++;
        }
        return cnt;
    }
}