import java.util.*;
class Solution {
    public int solution(int n) {
        int sum = 0;
        for(int i=1; i<=Math.sqrt(n); i++) {
            if(n % i == 0) {
                sum += i;
                int tmp = n / i;
                if(tmp != i) {
                    sum += tmp;   
                }
            }
        }
        return sum;
    }
}