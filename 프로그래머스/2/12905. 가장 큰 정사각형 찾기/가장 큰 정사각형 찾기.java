class Solution {
    public int solution(int [][]board) {
        int maxSize = 0;
        int rows = board.length;
        int cols = board[0].length;

        // DP 배열 선언
        int[][] dp = new int[rows][cols];

        // 1행과 1열은 그대로 복사 (첫 행과 첫 열은 그대로 유지)
        for (int i = 0; i < rows; i++) {
            dp[i][0] = board[i][0];
            maxSize = Math.max(maxSize, dp[i][0]);
        }
        
        for (int j = 0; j < cols; j++) {
            dp[0][j] = board[0][j];
            maxSize = Math.max(maxSize, dp[0][j]);
        }

        // 나머지 셀에 대해 DP 값을 채우기
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }

        // 최대 정사각형의 크기는 변의 길이의 제곱
        return maxSize * maxSize;
    }
}
