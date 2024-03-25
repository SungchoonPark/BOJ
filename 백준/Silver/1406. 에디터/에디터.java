import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String word = br.readLine();
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for (char c : word.toCharArray()) {
            left.push(String.valueOf(c));
        }

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("P")) {
                String c = st.nextToken();
                left.push(c);
            } else if (s.equals("L") && !left.isEmpty()) {
                right.push(left.pop());
            } else if (s.equals("B") && !left.isEmpty()) {
                left.pop();
            } else if (s.equals("D") && !right.isEmpty()) {
                left.push(right.pop());
            }
        }
        Stack<String> tmp = new Stack<>();
        while (!left.isEmpty()) {
            tmp.push(left.pop());
        }

        while (!tmp.isEmpty()) {
            sb.append(tmp.pop());
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);

    }
}