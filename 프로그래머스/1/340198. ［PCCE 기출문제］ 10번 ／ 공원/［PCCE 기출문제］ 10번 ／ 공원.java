class Solution {
    public int solution(int[] mats, String[][] park) {
        int n = park.length;
        int m = park[0].length;

        // 1. park → 숫자로 변환 (-1이면 빈 칸=1, 나머지는 장애물=0)
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = park[i][j].equals("-1") ? 1 : 0;
            }
        }

        // 2. DP 배열 생성
        int[][] dp = new int[n][m];
        int maxSquare = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) { // 빈 칸인 경우
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }

        // 3. mats 배열 중 설치 가능한 최대 값 선택
        int answer = -1;
        for (int size : mats) {
            if (size <= maxSquare) {
                answer = Math.max(answer, size);
            }
        }

        return answer;
    }
}