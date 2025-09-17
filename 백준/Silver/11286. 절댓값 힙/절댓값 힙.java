import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int caseNum = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>((i1, i2) -> {
            if (Math.abs(i1) == Math.abs(i2)) {
                return Math.toIntExact(i1 - i2);
            } else {
                return Math.toIntExact(Math.abs(i1) - Math.abs(i2));
            }
        });

        for (int i = 0; i < caseNum; i++) {
            long value = Long.parseLong(br.readLine());

            if (value == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    Long poll = pq.poll();
                    sb.append(poll).append("\n");
                }
            } else {
                pq.offer(value);
            }
        }

        System.out.print(sb);
    }

}