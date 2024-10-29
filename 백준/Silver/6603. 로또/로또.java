import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb= new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());

            if (st.countTokens() == 1) {
                break;
            }

            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            boolean[] visited = new boolean[k];

            for(int i=0; i<k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            comb(arr, visited, 0, k, 6);
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    private static void comb(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            // 다 봤음
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(arr[i] + " ");
                }
            }
            sb.append("\n");
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(arr, visited, i + 1, n, r-1);
            visited[i] = false;
        }
    }
}