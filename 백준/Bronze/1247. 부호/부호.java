import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());

            BigInteger sum = BigInteger.ZERO;
            for (int i1 = 0; i1 < n; i1++) {
                BigInteger tmp = new BigInteger(br.readLine());
                sum = sum.add(tmp);
            }

            if (sum.compareTo(BigInteger.ZERO) == 0) {
                sb.append("0\n");
            } else if (sum.compareTo(BigInteger.ZERO) > 0) {
                sb.append("+\n");
            } else {
                sb.append("-\n");
            }
        }

        System.out.print(sb);
    }
}