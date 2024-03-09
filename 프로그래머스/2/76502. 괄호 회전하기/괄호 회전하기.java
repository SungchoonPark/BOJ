import java.util.*;
class Solution {
    public int solution(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isCorrect(s.toCharArray(), i)) cnt++;
        }

        return cnt;
    }

    private boolean isCorrect(char[] str, int offset) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length; i++) {
            char c = str[(offset + i) % str.length];

            switch (c) {
                case '(' -> stack.push(')');
                case '[' -> stack.push(']');
                case '{' -> stack.push('}');
                case '}', ']', ')' -> {
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != c) return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}