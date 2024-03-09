import java.util.*;

class Solution {
    private static Stack<Character> stack = new Stack<>();
    boolean solution(String s) {
        int cnt = 0;
        boolean answer = true;
        for(char c : s.toCharArray()) {
            stack.add(c);
        }
        
        while(!stack.isEmpty()) {
            Character c = stack.peek();
            if(c == ')') cnt++;
            else cnt--;
            if(cnt < 0) return false;
            stack.pop();
        }
        
        return cnt == 0 ? true : false;
    }
}