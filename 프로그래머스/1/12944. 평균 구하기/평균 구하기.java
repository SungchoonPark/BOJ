import java.util.*;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double sum = 0;
        for(int i : arr) {
            sum += i;
        }
        return sum / arr.length;
    }
}