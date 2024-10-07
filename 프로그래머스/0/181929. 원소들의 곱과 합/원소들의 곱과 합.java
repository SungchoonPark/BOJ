import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        int x = 1;
        int sumPow = 0;
        int sum = 0;
        for(int i : num_list) {
            sum += i;
            x*=i;
        }
        sumPow = (int)Math.pow(sum, 2);
        
        return x < sumPow ? 1 : 0;
    }
}