import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] arr = skill.split("");
        
        for(String s : skill_trees) {
            boolean a = checkSkill(s, arr);
            // System.out.println("bool : " + a);
            if(a) answer++;
        }
        
        return answer;
    }
    
    public boolean checkSkill(String skill, String[] arr) {
        // 스킬트리가 가능한건지 따져보기
        Stack<Integer> stack = new Stack<>();
        for(String s : arr) {
            // System.out.println("idx : " + skill.indexOf(s));
            
            stack.push(skill.indexOf(s));
        }  
        
        while(!stack.isEmpty()) {
            if(stack.size() == 1) break;
            int tmp = stack.pop();
            if(tmp == -1) continue;
            // System.out.println("pop : " + tmp);
            // System.out.println("peek : " + stack.peek());
            
            if(tmp < stack.peek() || stack.peek() == -1) return false;
        }
        return true;
    }
}