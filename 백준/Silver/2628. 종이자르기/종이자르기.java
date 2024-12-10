import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        List<Integer> s = new ArrayList<>();
        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == 0) {
                // 세로
                s.add(Integer.parseInt(st.nextToken()));
            } else {
                // 가로
                g.add(Integer.parseInt(st.nextToken()));
            }
        }
        s.add(b);
        g.add(a);
        s.sort(Comparator.naturalOrder());
        g.sort(Comparator.naturalOrder());

        List<Integer> lens = new ArrayList<>();
        int start = 0;
        for (Integer i : s) {
            lens.add(i - start);
            start = i;
        }

        List<Integer> leng = new ArrayList<>();
        start = 0;
        for (Integer i : g) {
            leng.add(i - start);
            start = i;
        }

        int max = Integer.MIN_VALUE;
        for (Integer len : lens) {
            for (Integer i : leng) {
                int tmp = len * i;
                if (tmp > max) max = tmp;
            }
        }

        System.out.println(max);
    }
}