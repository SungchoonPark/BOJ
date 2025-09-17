import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int caseNum = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < caseNum; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int addNum = 0;
        if (pq.size() == 1) {
            System.out.println(0);
            return;
        } else {
            while(!pq.isEmpty()) {
                Integer i1 = pq.poll();
                Integer i2 = pq.poll();

                addNum += (i1 + i2);
                if (pq.isEmpty()) break;

                pq.offer(i1 + i2);
            }
        }

        System.out.println(addNum);
    }

}