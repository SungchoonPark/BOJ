import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            if (s.equals("push")) {
                int a = Integer.parseInt(st.nextToken());
                stack.push(a);
            } else if (s.equals("top")) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());
            } else if (s.equals("size")) {
                System.out.println(stack.size());
            } else if (s.equals("pop")) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.pop());
            } else if (s.equals("empty")) {
                if (stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
        }

    }
}