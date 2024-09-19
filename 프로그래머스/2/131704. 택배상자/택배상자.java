import java.util.*;

class Solution {
    public int solution(int[] order) {
        int idx = 0;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<order.length; i++) {
            st.push(i + 1);
            
            while(!st.isEmpty()) {
                if(st.peek() == order[idx]) {
                    st.pop();
                    idx++;
                } else {
                    break;
                }
            }
        }
        
        return idx;
    }
}