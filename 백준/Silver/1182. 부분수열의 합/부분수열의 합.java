import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static int n, s;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        search(0, 0);

        if (s == 0) result--;
        System.out.println(result);
    }

    private static void search(int cur, int num) {
        if (cur == n) {
            if (num == s) result++;
            return;
        }

        search(cur + 1, num);
        search(cur + 1, num + arr[cur]);
    }
}