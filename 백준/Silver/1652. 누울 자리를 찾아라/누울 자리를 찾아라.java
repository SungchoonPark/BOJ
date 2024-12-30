import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        String[][] tmp = new String[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            tmp[i] = arr[i].split("");
        }

        int rcnt = 0;
        int ccnt = 0;
        for (int i = 0; i < n; i++) {
            String[] split = arr[i].split("X");
            for (String s : split) {
                if (s.contains("..")) rcnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(tmp[j][i]);
            }
            String[] string = sb.toString().split("X");
            for (String s : string) {
                if (s.contains("..")) ccnt++;
            }
        }

        System.out.print(rcnt + " " + ccnt);
    }
}