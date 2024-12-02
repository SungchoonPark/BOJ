import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        PriorityQueue<Height> pq = new PriorityQueue<>((h1, h2) -> h2.h - h1.h);
        for (int i = 1; i <= n; i++) {
            pq.add(new Height(i, Integer.parseInt(st.nextToken())));
        }

        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()) {
            Height curH = pq.poll();
            list.add(curH.left, curH.h);
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    static class Height {
        int h;
        int left;

        public Height(int h, int left) {
            this.h = h;
            this.left = left;
        }
    }
}