import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[num_list.length];
        
        for(int i : num_list) {
            stack.push(i);
        }
        
        int i = 0;
        while(!stack.isEmpty()) {
            arr[i] = stack.pop();
            i++;
        }
        
        return arr;
    }
}