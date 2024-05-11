import java.util.*;
class Solution {
    public int solution(int[] arr) {
        if(arr.length == 1) return arr[0];
        int answer = arr[0];
        for(int i=1; i<arr.length; i++) {
            answer = answer * arr[i] / gcd(answer, arr[i]);
        }
        return answer;
    }
    
    private int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}