import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int min = 99999999;
        for(int i=0; i<prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }

            maxProfit = Math.max(maxProfit, prices[i] - min);
        }

        return maxProfit;
    }
}