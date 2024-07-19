import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Integer> list;
    static int[] arr;
    static int[] sum;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        sum = new int[n+2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n+2; i++) {
            sum[i] = sum[i-1] + arr[i-1];
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(sum(start, end)).append("\n");
        }
        System.out.print(sb);
    }

    private static int sum(int start, int end) {
        return sum[end+1] - sum[start];
    }
}
