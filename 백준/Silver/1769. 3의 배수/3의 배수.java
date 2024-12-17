import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String a = br.readLine();

        int cnt = 0;
        while(true) {
            if (a.length() == 1) {
                System.out.println(cnt);
                if (Integer.parseInt(a) % 3 == 0) {
                    System.out.println("YES");
                    return;
                }

                System.out.println("NO");
                return;
            }

            long n = 0;
            for (char c : a.toCharArray()) {
                n += c - '0';
            }

            a = String.valueOf(n);
            cnt++;
        }
    }
}