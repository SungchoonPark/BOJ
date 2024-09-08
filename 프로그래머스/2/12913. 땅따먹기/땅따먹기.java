
class Solution {
    int solution(int[][] land) {
        int n = land.length;

        // 이전 행까지의 최댓값을 저장하는 배열
        int[][] dp = new int[n][4];

        // 첫 번째 행은 그대로 사용
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        // 두 번째 행부터 시작
        for (int i = 1; i < n; i++) {
            dp[i][0] = land[i][0] + Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3]));
            dp[i][1] = land[i][1] + Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3]));
            dp[i][2] = land[i][2] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3]));
            dp[i][3] = land[i][3] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
        }

        // 마지막 행에서 최댓값을 반환
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], Math.max(dp[n-1][2], dp[n-1][3])));
    }
}
