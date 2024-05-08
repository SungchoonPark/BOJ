import java.util.*;
class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        
        while(true) {
            n++;
            if(cnt == Integer.bitCount(n)) return n;
        }
    }
}