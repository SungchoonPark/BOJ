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

        PriorityQueue<Long> pq = new PriorityQueue<>(
                (n1, n2) -> {
                    long absDiff = Math.abs(n1) - Math.abs(n2);
                    if (absDiff == 0) {
                        return Long.compare(n1, n2);
                    } else {
                        return Long.compare(absDiff, 0);
                    }
                }
        );

        for (int i = 0; i < num; i++) {
            long n = Long.parseLong(br.readLine());

            if (n == 0) {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            } else {
                pq.offer(n);
            }
        }
        System.out.println(sb);
    }
}