import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(Math.max(n, m), Math.min(n, m));
        int lcm = gcd * (n / gcd) * (m / gcd);
        return new int[]{gcd, lcm};
    }
    
    private int gcd(int a, int b) {
        if(b == 0 ) return a;
        else return gcd(b, a % b);
    }
}