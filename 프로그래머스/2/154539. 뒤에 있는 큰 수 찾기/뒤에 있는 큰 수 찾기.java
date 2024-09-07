import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> result = new Stack<>();
        Stack<Integer> size = new Stack<>();
        for(int n : numbers) stack.push(n);
        size.push(Integer.MAX_VALUE);
        
        while(!stack.isEmpty()) {
            int curValue = stack.pop();
            
            while(true) {
                if(curValue >= size.peek()) {
                    size.pop();
                } else {
                    result.push(size.peek());                    
                    break;
                }
            }
            size.push(curValue);
        }
        
        int i = 0;
        while(!result.isEmpty()) {
            int popValue = result.pop();
            if(popValue == Integer.MAX_VALUE) {
                answer[i++] = -1;
            } else {
                answer[i++] = popValue;
            }
        }
        return answer;
    }
}