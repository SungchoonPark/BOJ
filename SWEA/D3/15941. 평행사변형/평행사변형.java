import java.io.*;
import java.util.*;

public class Solution {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            sb.append("#").append(i + 1).append(" ").append((int) Math.pow(n, 2)).append("\n");
        }

        System.out.print(sb);
    }
}