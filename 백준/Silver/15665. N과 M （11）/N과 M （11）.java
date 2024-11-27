import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;
    static int[] arr;

    static List<String> result = new ArrayList<>();
    static Set<String > set = new HashSet<>();
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
            List<Integer> list = new ArrayList<>();
            list.add(i);

            search(list, 0, m - 1);
        }

        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void search(List<Integer> list, int start, int r) {
        if (r == 0) {
            StringBuilder tmp = new StringBuilder();
            list.forEach(i -> tmp.append(arr[i]).append(" "));

            if (!set.contains(tmp.toString())) result.add(tmp.toString());
            set.add(tmp.toString());
            return;
        }

        for (int i = start; i < n; i++) {
            list.add(i);
            int size = list.size();
            search(list, start, r-1);
            list.remove(size - 1);
        }
    }
}