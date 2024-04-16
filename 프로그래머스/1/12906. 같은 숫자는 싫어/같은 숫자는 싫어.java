import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(stack.peek() != arr[i]) {
                stack.push(arr[i]);
            } 
        }
        
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[stack.size()];
        int size = stack.size();
        for(int i=size - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}