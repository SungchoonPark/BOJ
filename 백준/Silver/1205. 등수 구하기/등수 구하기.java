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
        int taesooScore = Integer.parseInt(st.nextToken());
        int maximumSize = Integer.parseInt(st.nextToken());

        if (n==0) {
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            pq.add(num);
        }

        if (pq.size() == maximumSize) {
            // 태수의 점수가 들어갈 수 있는지
            if (taesooScore <= pq.peek()) {
                System.out.println(-1);
                return;
            }

            pq.poll();
            pq.add(taesooScore);
        } else {
            pq.add(taesooScore);
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>((n1, n2) -> n2 - n1);
        pq2.addAll(pq);

        int consecutiveCnt = 1;
        int curRank = 1;
        int prevScore = pq2.peek();

        boolean flag = true;
        while(!pq2.isEmpty()) {
            Integer score = pq2.poll();
            if (flag) {
                flag = false;
                
                if (score == taesooScore) {
                    System.out.println(curRank);
                    return;
                }
                continue;
            }

            if (score == prevScore) {
                consecutiveCnt++;
            } else {
                curRank += consecutiveCnt;
                consecutiveCnt = 1;
            }
            if (score == taesooScore) {
                System.out.println(curRank);
                return;
            }
        }
    }
}