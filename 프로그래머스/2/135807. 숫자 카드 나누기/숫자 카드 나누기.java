import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int r1 = 0;
        int r2 = 0;
        
        int a1 = arrayA[0];
        for(int i=1; i<arrayA.length; i++) {
            a1 = gcd(a1, arrayA[i]);
        }
        if(isValid(a1, arrayB)) r1 = a1;
        
        int a2 = arrayB[0];
        for(int i=1; i<arrayB.length; i++) {
            a2 = gcd(a2, arrayB[i]);
        }
        if(isValid(a2, arrayA)) r2 = a2;
        
        return Math.max(r1, r2);
    }
    
    private static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
    
    private static boolean isValid(int checkNum, int[] arr) {
        for(int i : arr) {
            if(i % checkNum == 0) return false;
        }
        
        return true;
    }
}