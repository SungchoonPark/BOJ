import java.util.*;
class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length()-k];
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<number.length(); i++) {
            Character c = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        
        for(int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}