import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n));

        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }
        long result = 0;
        while(!pq.isEmpty()) {
            int a = pq.poll();
            int b = pq.poll();
            result += (a+b);
            if (pq.isEmpty()) {
                break;
            }
            pq.offer(a + b);
        }

        System.out.print(result);
    }
}