import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            search(1, i, 0, list);
        }

        System.out.println(min);
    }

    private static void search(int depth, int startIdx, int cost, List<Integer> path) {
        Integer lastIdx = path.get(path.size() - 1);
        if (depth == n) {
            // 마지막 도시에서 첫 도시로 갈 수있는지
            if (arr[lastIdx][startIdx] != 0) {
                cost += arr[lastIdx][startIdx];
                min = Math.min(min, cost);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (arr[lastIdx][i] != 0 && !path.contains(Integer.valueOf(i))) {
                path.add(i);
                int size = path.size();
                search(depth + 1, startIdx, cost + arr[lastIdx][i], path);
                path.remove(size - 1);
            }
        }
    }
}