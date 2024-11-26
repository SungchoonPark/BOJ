import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            search(1, i, list);
        }

        System.out.print(sb);
    }

    private static void search(int depth, int start, List<Integer> list) {
        if (depth == m) {
            StringBuilder tmp = new StringBuilder();
            for (Integer i : list) {
                tmp.append(arr[i]).append(" ");
            }

            sb.append(tmp).append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            list.add(i);
            int size = list.size();
            search(depth + 1, i, list);
            list.remove(size - 1);
        }
    }
}