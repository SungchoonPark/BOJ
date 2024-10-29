import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<>();
        int cnt = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());

            if (st.countTokens() == 2) {
                String ope = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                queue.offer(num);
                continue;
            }

            String ope = st.nextToken();
            if (ope.equals("pop")) {
                if (queue.size() == 0) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else if (ope.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (ope.equals("empty")) {
                if (queue.size() == 0) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (ope.equals("front")) {
                if (queue.size() == 0) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
            } else if (ope.equals("back")) {
                if (queue.size() == 0) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}