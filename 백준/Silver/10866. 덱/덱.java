import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            if (s.equals("push_back")) {
                int a = Integer.parseInt(st.nextToken());
                deque.addLast(a);
            } else if (s.equals("push_front")) {
                int a = Integer.parseInt(st.nextToken());
                deque.addFirst(a);
            } else if (s.equals("front")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekFirst());
            } else if (s.equals("back")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekLast());
            } else if (s.equals("empty")) {
                if (deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (s.equals("pop_front")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollFirst());
            } else if (s.equals("pop_back")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollLast());
            } else if (s.equals("size")) {
                System.out.println(deque.size());
            }
        }
    }
}