import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int dasomCnt = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int i = 0; i < n-1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(!pq.isEmpty()) {
            if (pq.peek() < dasomCnt) {
                break;
            }

            Integer value = pq.poll();
            dasomCnt++;
            result++;
            pq.offer(value - 1);
        }


        System.out.println(result);
    }
}