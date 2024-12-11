import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int[] health;
    static int[] pleasures;

    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        health = new int[n];
        pleasures = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pleasures[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                boolean[] visited = new boolean[n];
                visited[j] = true;
                comb(visited, j, i-1);
            }
        }

        System.out.println(max);
    }

    private static void comb(boolean[] visited, int start, int r) {
        if (r == 0) {
            int tmpPleasure = 0;
            int h  = 100;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    tmpPleasure += pleasures[i];
                    h -= health[i];
                }
            }

            if (h > 0 && tmpPleasure > max) {
                max = tmpPleasure;
            }

            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(visited, i + 1, r-1);
                visited[i] = false;
            }
        }
    }
}