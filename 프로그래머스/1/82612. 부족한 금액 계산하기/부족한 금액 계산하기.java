import java.util.*;
class Solution {
    public long solution(int price, int money, int count) {
        long tmp = 0;
        for(int i=1; i<=count; i++) {
            tmp += price * i;
        }

        return tmp - money > 0 ? tmp - money : 0;
    }
}