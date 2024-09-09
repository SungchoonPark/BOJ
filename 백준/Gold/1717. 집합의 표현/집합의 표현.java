import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int [] arr = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 1) {
                // a 와 b가 같은 집합에 속하는지?
                int ap = find(arr, a);
                int bp = find(arr, b);
                if (ap != bp) {
                    sb.append("NO").append("\n");
                } else {
                    sb.append("YES").append("\n");

                }
            } else {
                // a 와 b 집합을 합쳐라
                union(arr, a, b);
            }
        }
        System.out.println(sb);
    }

    private static void union(int[] arr, int a, int b) {
        int aParent = find(arr, a);
        int bParent = find(arr, b);
        int parent = Math.min(aParent, bParent);
        int child = Math.max(aParent, bParent);

        arr[child] = parent;
    }

    private static int find(int[] arr, int n) {
        if (arr[n] == n) return n;
        return arr[n] = find(arr, arr[n]);
    }
}
