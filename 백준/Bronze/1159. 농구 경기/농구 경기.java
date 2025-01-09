import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int[] arr = new int[26];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            char first = s.toCharArray()[0];

            arr[first - 'a']++;
        }

        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 5) {
                flag = true;
                sb.append((char)(i + 'a'));
            }
        }

        if (!flag) {
            System.out.println("PREDAJA");
            return;
        }
        System.out.print(sb);
    }
}