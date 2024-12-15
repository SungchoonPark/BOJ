import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!map.containsKey(num)) {
                order.add(num); // 처음 등장한 숫자의 순서를 기록
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Num> pq = new PriorityQueue<>((n1, n2) -> {
            if (n2.cnt != n1.cnt) {
                return n2.cnt - n1.cnt; // 빈도 내림차순
            } else {
                return order.indexOf(n1.num) - order.indexOf(n2.num); // 순서 오름차순
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Num(entry.getKey(), entry.getValue()));
        }

        while(!pq.isEmpty()) {
            Num poll = pq.poll();

            for (int i = 0; i < poll.cnt; i++) {
                sb.append(poll.num).append(" ");
            }
        }

        System.out.println(sb);
    }

    static class Num {
        int num;
        int cnt;

        public Num(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}