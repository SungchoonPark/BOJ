import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {
            char[] a = br.readLine().toCharArray();

            if (nextPermutation(a)) {
                sb.append(new String(a)).append('\n');
            } else {
                sb.append(new String(a)).append('\n');
            }
        }
        System.out.print(sb);
    }

    static boolean nextPermutation(char[] a) {
        int i = a.length - 2;

        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false;

        int j = a.length - 1;
        while (a[j] <= a[i]) j--;

        swap(a, i, j);
        reverse(a, i + 1, a.length - 1);

        return true;
    }

    static void swap(char[] a, int i, int j) {
        char tmp = a[i]; a[i] = a[j]; a[j] = tmp;
    }

    static void reverse(char[] a, int l, int r) {
        while (l < r) {
            swap(a, l++, r--);
        }
    }
}