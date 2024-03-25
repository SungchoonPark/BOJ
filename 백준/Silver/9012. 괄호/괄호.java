import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();
            String s = br.readLine();

            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (c == '(') stack.push("(");
                else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty() && flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}