class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        
        for(int i=0; i<puddles.length; i++) {
            int a = puddles[i][0];
            int b = puddles[i][1];
            
            dp[b - 1][a - 1] = -1;
        }
        
        dp[0][0] = 1;
        
        for(int i=0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(dp[i][j] == -1) {
                    // 물웅덩이
                    dp[i][j] = 0;
                    continue;
                }
                
                if(i > 0) dp[i][j] += dp[i-1][j];
                if(j > 0) dp[i][j] += dp[i][j-1];
                
                dp[i][j] %= 1_000_000_007;
            }
        }
        
        return dp[n - 1][m - 1];
    }
}