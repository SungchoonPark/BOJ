import java.util.*;

class Solution {
    static int[] distX = new int[]{1, -1, 0, 0};
    static int[] distY = new int[]{0, 0, 1, -1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        String s = board[h][w];
        for(int i=0; i<4; i++) {
            int newX = h + distX[i];
            int newY = w + distY[i];
            if(newX >= 0 && newY >= 0 && newX < n && newY < n) {
                String tmp = board[newX][newY];
                if(tmp.equals(s)) answer++;
            }
        }
        
        return answer;
    }
}