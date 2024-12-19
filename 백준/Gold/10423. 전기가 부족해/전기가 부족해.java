import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n;
    static int m;
    static int k;

    static List<Line> lines = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            // 발전소 입력해놓기
            int i1 = Integer.parseInt(st.nextToken());
            parent[i1] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            lines.add(new Line(t1, t2, cost));
        }

        lines.sort(Comparator.comparingInt(l -> l.cost));

        int result = 0;
        for (Line line : lines) {
            if (union(line.town1, line.town2)) {
                result += line.cost;
            }
        }

        System.out.println(result);
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) return false;
        else {
            if (parentA == 0) parent[parentB] = parentA;
            else parent[parentA] = parentB;
            return true;
        }
    }

    static class Line {
        int town1;
        int town2;
        int cost;

        public Line(int town1, int town2, int cost) {
            this.town1 = town1;
            this.town2 = town2;
            this.cost = cost;
        }
    }
}