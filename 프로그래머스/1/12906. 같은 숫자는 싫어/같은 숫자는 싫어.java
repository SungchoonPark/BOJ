import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int value : arr) {
            if(stack.isEmpty()) stack.addFirst(value);
            else {
                if(stack.peekFirst() == value) continue;
                else {
                    stack.addFirst(value);
                }
            }
        }
        
        int[] result = new int[stack.size()];
        for(int i=0; i<result.length; i++) {
            result[i] = stack.pollLast();
        }
        
        return result;
    }
}