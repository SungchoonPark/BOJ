import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String s = br.readLine();

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                // 알파벳은 그냥 출력
                sb.append(c);
            } else {
                // 스택이 비어있다면 그대로 연산자 넣기
                int priority = getPriority(c);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    // peek 했을 때 현재 연산자보다 우선순위가 높은 연산자는 pop해야함
                    if (c == ')') {
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                        stack.pop();
                    } else {
                        while (!stack.isEmpty() &&  stack.peek() != '(' && getPriority(stack.peek()) >= priority ) {
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    private static int getPriority(char c) {
        if (c == '+') {
            return 1;
        } else if (c == '-') {
            return 1;
        } else if (c == '*') {
            return 2;
        } else if (c == '/') {
            return 2;
        } else if (c == '(') {
            return 3;
        } else if (c == ')') {
            return 3;
        }
        return 0;
    }
}