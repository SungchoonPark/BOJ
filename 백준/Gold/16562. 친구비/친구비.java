import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m, k;
    static int[] moneys;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        moneys = new int[n + 1];
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            moneys[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            union(f1, f2);
        }

        // 집합의 개수 파악
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i<=n; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }

        int tmpFriendPrice = 0;
        boolean[] isVisited = new boolean[n+1];
        for (int i = 1; i < n + 1; i++) {
            int parent = find(i);
            if (!isVisited[parent]) {
                isVisited[parent] = true;
                tmpFriendPrice += moneys[parent];
            }
        }

        if (tmpFriendPrice > k) System.out.print("Oh no");
        else System.out.print(tmpFriendPrice);
    }

    private static void union(int a, int b) {
        int ap = find(a);
        int bp = find(b);

        if (moneys[ap] < moneys[bp]) arr[bp] = ap;
        else arr[ap] = bp;
    }

    private static int find(int n) {
        if (arr[n] == n) return n;
        return arr[n] = find(arr[n]);
    }
}
