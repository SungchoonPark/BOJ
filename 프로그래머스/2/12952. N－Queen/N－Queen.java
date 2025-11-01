class Solution {
    int[] board;
    int count = 0;
    
    public int solution(int n) {
        board = new int[n];
        
        back(0, n);
        return count;
    }
    
    private void back(int depth, int n) {
        if(depth == n) {
            count++;
            return;
        }
        
        for(int col = 0; col < n; col++) {
            board[depth] = col;
            if(isPossible(depth)) {
                back(depth + 1, n);
            }
        }
    }
    
    private boolean isPossible(int row) {
        // 세로로 놓을 수 있냐?
        for(int i=0; i<row; i++) {
            if(board[i] == board[row]) return false;
            
            if(Math.abs(board[row] - board[i]) == row - i) return false;
        }
        
        return true;
    }
}