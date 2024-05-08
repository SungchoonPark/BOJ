import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        // moves로 움직이며 바구니에 담고 똑같으면 터트리고 cnt +=2 해주면될듯
        int answer = 0;
        int len = board.length;
        Stack<Integer>[] stackArr = new Stack[board[0].length];
        Stack<Integer> basket = new Stack<>();
        for(int i=0; i<stackArr.length; i++) {
            stackArr[i] = new Stack<>();
        }
        
        for(int i=len - 1; i>=0; i--) {
            for(int j=0; j<len; j++) {
                if(board[i][j] == 0) continue;
                
                stackArr[j].push(board[i][j]);
            }
        }
        
        for(int i=0; i<moves.length; i++) {
            if(stackArr[moves[i] - 1].isEmpty()) continue;
            
            Integer pop = stackArr[moves[i] - 1].pop();
            
            if(!basket.isEmpty()) {
                if(pop == basket.peek()) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(pop);  
                }
            } else {
                basket.push(pop);
            }
        }
        return answer;
    }
}