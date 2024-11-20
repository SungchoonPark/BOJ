import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.countTokens() == 1) {
                int com = Integer.parseInt(st.nextToken());

                if (com == 2) {
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.pop());
                    }
                } else if (com == 3) {
                    System.out.println(stack.size());
                } else if (com == 4) {
                    if (stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                } else if (com == 5) {
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                }
            } else {
                st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                stack.push(num);
            }
        }
    }
}