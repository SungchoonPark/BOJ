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

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            q.offer(i);
        }
        int idx = 1;
        while (!q.isEmpty()) {
            if (idx != K) {
                idx++;
                q.offer(q.poll());
            } else {
                idx = 1;
                list.add(q.poll());
            }
        }
        sb.append("<");
        for (int i=0; i<list.size(); i++) {
            if (i == list.size() - 1) sb.append(list.get(i));
            else sb.append(list.get(i)).append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}