import java.util.*;
class Solution {
    public static int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];

        for(int i=0; i<prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                // 스택의 원소가 짝을 찾은 경우임!!
                Integer index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            Integer index = stack.pop();
            result[index] = prices.length - index - 1;
        }
        return result;
    }
}