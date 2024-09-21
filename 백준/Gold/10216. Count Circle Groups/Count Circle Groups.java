import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int testNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < testNum; i++) {
            Set<Integer> set= new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            Enemy[] enemies = new Enemy[n];

            for (int j = 0; j < n + 1; j++) {
                arr[j] = j;
            }

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                enemies[j] = new Enemy(j + 1, x, y, r);
            }

            for (int j = 0; j < n; j++) {
                Enemy e1 = enemies[j];
                for (int k = j + 1; k < n; k++) {
                    Enemy e2 = enemies[k];
                    if (getParent(arr, e1.n) == getParent(arr, e2.n)) continue;

                    double d = (Math.pow(e1.d + e2.d, 2));
                    if (getDistance(e1, e2) <= d) {
                        // 둘이 속해있음
                        union(arr, e1.n, e2.n);
                    }
                }
            }

            for (int j = 1; j < n + 1; j++) {
                set.add(getParent(arr ,j));
            }
            sb.append(set.size()).append("\n");
        }

        System.out.print(sb);
    }

    private static double getDistance(Enemy e1, Enemy e2) {
        return Math.pow((e1.x - e2.x), 2) + Math.pow((e1.y - e2.y), 2);
    }

    private static int getParent(int[] arr, int n) {
        if (arr[n] == n) return n;
        return arr[n] = getParent(arr, arr[n]);
    }

    private static void union(int[] arr, int a, int b) {
        int ap = getParent(arr, a);
        int bp = getParent(arr, b);

        if (ap < bp) {
            arr[bp] = ap;
        } else {
            arr[ap] = bp;
        }
    }

    static class Enemy {
        int n;
        int x;
        int y;
        int d;

        public Enemy(int n, int x, int y, int d) {
            this.n = n;
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
