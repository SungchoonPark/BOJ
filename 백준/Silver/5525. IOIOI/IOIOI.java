import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String p = makeP(n);

        int cnt = 0;
        int len = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for (int i = 0; i <= len - p.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j =i ; j < i + p.length(); j++) {
                sb.append(s.charAt(j));
            }
            if (sb.toString().equals(p)) cnt++;
        }

        System.out.println(cnt);
    }

    private static String makeP(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (n + n + 1); i++) {
            String s = (i%2 == 0) ? "I" : "O";
            sb.append(s);
        }
        return sb.toString();
    }
}