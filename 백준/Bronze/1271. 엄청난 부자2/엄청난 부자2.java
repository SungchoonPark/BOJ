import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static BigInteger n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = new BigInteger(st.nextToken());
        m = new BigInteger(st.nextToken());

        BigInteger result = n.divide(m);
        BigInteger tmp = n.remainder(m);

        System.out.println(result);
        System.out.println(tmp);

    }
}