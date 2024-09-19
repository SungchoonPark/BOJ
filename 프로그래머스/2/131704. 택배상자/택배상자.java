import java.util.*;

class Solution {
    public int solution(int[] order) {
        // order -> 택배 기사님이 원하는 상자 순서
        // return -> 영재가 실을 수 있는 상자 개수
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i<= order.length; i++) q.add(i);
        
        for(int i=0; i<order.length; i++) {
            int wantNum = order[i];
            boolean flag = false;
            
            if(!stack.isEmpty()) {
                if(wantNum == stack.peek()) {
                    flag = true;
                    stack.pop();
                    answer++;
                    continue;
                }
            }
            
            while(!q.isEmpty()) {
                Integer curBN = q.poll();
                if(curBN == wantNum) {
                    flag = true;
                    answer++;
                    break;
                } 
                stack.push(curBN);
            }
            if(!flag) break;
        }
        
        
        return answer;
    }
}