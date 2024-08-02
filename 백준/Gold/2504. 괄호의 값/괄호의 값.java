import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        // ), ] 이쪽이 올 때 그 다음 괄호가 ( 또는 [ 이게 아니면 x2 or x3 중첩을 해주고, (, [ 이거면 () -> 2, [] -> 3 으로 바꾸고 중첩 값을 곱해줌. -> 저장은 result
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String s = br.readLine();

        if (!isValidInput(s)) {
            System.out.println(0);
            return;
        }

        calculate(s);
        System.out.println(result);
    }


    private static boolean isValidInput(String input) {
        Stack<String> stack = new Stack<>();

        for (String s : input.split("")) {
            if (s.equals("(") || s.equals("[")) {
                stack.push(s);
            } else if (s.equals(")")) {
                if (stack.isEmpty() || !stack.pop().equals("(")) {
                    return false;
                }

            } else if (s.equals("]")) {
                if (stack.isEmpty() || !stack.pop().equals("[")) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static void calculate(String input) {
        Stack<String> stack = new Stack<>();
        int temp = 0;

        for (String s : input.split("")) {
            if (s.equals("(") || s.equals("[")) {
                stack.push(s);
            } else if (s.equals(")")) {
                temp = 0;
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    temp += Integer.parseInt(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                    stack.push(String.valueOf(temp == 0 ? 2 : 2 * temp));
                }
            } else if (s.equals("]")) {
                temp = 0;
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    temp += Integer.parseInt(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek().equals("[")) {
                    stack.pop();
                    stack.push(String.valueOf(temp == 0 ? 3 : 3 * temp));
                }
            }
        }

        while (!stack.isEmpty()) {
            result += Integer.parseInt(stack.pop());
        }
    }
}
