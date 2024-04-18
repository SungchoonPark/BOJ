import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        int empty = n;
        int receiveBottle = 0;
        while(empty >= a) {
            int tmp = (empty / a) * b;
            receiveBottle += tmp;
            empty = empty % a +  tmp;
        }
        return receiveBottle;
    }
}