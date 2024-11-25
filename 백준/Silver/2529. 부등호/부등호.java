import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String[] coms;
    static boolean[] visited = new boolean[10]; // 숫자 방문 여부 체크
    static int n;
    static String max = "", min = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        coms = new String[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < coms.length; i++) {
            coms[i] = st.nextToken();
        }

        // DFS 시작
        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            dfs(0, String.valueOf(i));
            visited[i] = false;
        }

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth, String nums) {
        if (depth == n) {
            // 조건을 만족하면 최대/최소값 업데이트
            if (min.isEmpty() || Long.parseLong(nums) < Long.parseLong(min)) {
                min = nums;
            }
            if (max.isEmpty() || Long.parseLong(nums) > Long.parseLong(max)) {
                max = nums;
            }
            return;
        }

        // 다음 숫자 탐색
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                // 현재 숫자와 다음 숫자의 조건 비교
                if (isValid(nums.charAt(nums.length() - 1) - '0', i, coms[depth])) {
                    visited[i] = true;
                    dfs(depth + 1, nums + i);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean isValid(int prev, int next, String op) {
        if (op.equals("<")) {
            return prev < next;
        } else {
            return prev > next;
        }
    }
}