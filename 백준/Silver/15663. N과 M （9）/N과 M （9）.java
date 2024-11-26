import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;
    static int[] arr;

    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(i);
            boolean[] visited = new boolean[n];
            visited[i] = true;
            comb(visited, m -1, path);
        }

        for (String s : list) {
            System.out.print(s);
        }
    }

    private static void comb(boolean[] visited, int r, List<Integer> path) {
        if (r == 0) {
            StringBuilder tmp = new StringBuilder();
            for (Integer i : path) {
                tmp.append(arr[i]).append(" ");
            }
            tmp.append("\n");
            if (!list.contains(tmp.toString())) list.add(tmp.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(i);
                int size = path.size();
                comb(visited, r - 1, path);
                path.remove(size -1);
                visited[i] = false;
            }
        }
    }
}