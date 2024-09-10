import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int unionReturn = union(arr, a, b);
            if (unionReturn == -1) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(0);
    }

    private static int union(int[] arr, int a, int b) {
        int ap = find(arr, a);
        int bp = find(arr, b);

        if (ap == bp) return -1;
        if (ap < bp) arr[bp] = ap;
        else arr[ap] = bp;
        return 1;
    }

    private static int find(int[] arr, int a) {
        if (arr[a] == a) {
            return a;
        }

        return arr[a] = find(arr, arr[a]);
    }
}
