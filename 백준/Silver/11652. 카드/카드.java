import java.io.*;
import java.util.*;

class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxC = Integer.MIN_VALUE;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (Map.Entry<Long, Integer> longIntegerEntry : map.entrySet()) {
            Long key = longIntegerEntry.getKey();
            Integer cnt = longIntegerEntry.getValue();

            if (cnt >= maxC) {
                if (cnt == maxC) {
                    pq.add(key);
                } else{
                    pq = new PriorityQueue<>();
                    pq.add(key);
                    maxC = cnt;
                }
            }
        }

        System.out.println(pq.poll());
    }
}