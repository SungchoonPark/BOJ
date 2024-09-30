import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int[][] dp = new int[board.length][board[0].length];
        int result = 0;
        
        // 1행 1열에 기존 값들 넣기
        for(int j = 0; j < board[0].length; j++) {
            dp[0][j] = board[0][j];
            result = Math.max(result, dp[0][j]);  // 첫 번째 행에서 최대값 갱신
        }
        
        // 첫 번째 열 초기화 및 최대값 갱신
        for(int i = 1; i < board.length; i++) {
            dp[i][0] = board[i][0];
            result = Math.max(result, dp[i][0]);  // 첫 번째 열에서 최대값 갱신
        }
        
        for(int i=1; i<board.length; i++) {
            for(int j=1; j<board[0].length; j++) {
                if(board[i][j] == 0) continue;
                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                result = Math.max(result, dp[i][j]);
            }
        }
        
        return result * result;
    }
}