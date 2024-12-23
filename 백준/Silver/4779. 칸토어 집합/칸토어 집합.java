import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = new StringBuilder();
        //
        while (true) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) break;
            int i = Integer.parseInt(s);

            if (i == 0) {
                result.append("-").append("\n");
                continue;
            }

            StringBuilder tmp = new StringBuilder();
            recur((int)Math.pow(3, i), tmp);
            result.append(tmp).append("\n");
        }

        System.out.println(result);
    }

    private static void recur(int n, StringBuilder tmp) {
        if (n == 3) {
            tmp.append("-").append(" ").append("-");
            return;
        }

        recur(n/3, tmp);
        tmp.append(" ".repeat(n / 3));
        recur(n/3, tmp);
    }
}