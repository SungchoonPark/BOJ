import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            if (stack.isEmpty()) {
                if (num > a) {
                    System.out.println("NO");
                    return;
                } else {
                    while (num != a + 1) {
                        stack.push(num++);
                        sb.append("+" + "\n");
                    }
                    stack.pop();
                    sb.append("-" + "\n");
                }
            } else {
                if (num > a) {
                    while (!stack.isEmpty()) {
                        Integer pop = stack.pop();
                        sb.append("-" + "\n");
                        if (pop == a) break;
                        if (pop < a) {
                            System.out.println("NO");
                            return;
                        }
                    }
                } else {
                    while (num != a + 1) {
                        stack.push(num++);
                        sb.append("+" + "\n");
                    }
                    stack.pop();
                    sb.append("-" + "\n");
                }
            }

        }

        System.out.println(sb);
    }
}