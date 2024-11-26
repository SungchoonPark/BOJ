import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            comb(visited, i, m-1);
        }
        System.out.print(sb);
    }

    private static void comb(boolean[] visited, int start, int r) {
        if (r == 0) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) tmp.append(arr[i]).append(" ");
            }
            
            sb.append(tmp).append("\n");
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(visited, i, r-1);
                visited[i] = false;
            }
        }
    }
}