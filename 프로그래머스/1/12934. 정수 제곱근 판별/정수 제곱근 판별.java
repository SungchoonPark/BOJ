import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        System.out.println("Math.sqrt(n) : " + Math.sqrt(n));
        if(Math.sqrt(n) * 10 % 10 == 0) {
            answer = (int)(Math.sqrt(n)) + 1;
        } else {
            return -1;
        }
        return (long) Math.pow(answer, 2);
    }
}