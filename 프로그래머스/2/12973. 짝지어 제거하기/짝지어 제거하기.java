import java.util.*;

class Solution {
    
    public int solution(String s) {
        
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 스택의 맨 위 문자와 현재 문자가 같으면 스택에서 제거
            } else {
                stack.push(c); // 스택이 비어있거나 현재 문자가 스택의 맨 위 문자와 다르면 스택에 추가
            }
        }

        // 스택에 남은 문자가 있다면 중복된 문자가 남아있는 것이므로 0 반환, 없다면 1 반환
        return stack.isEmpty() ? 1 : 0;
    }
}