import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        int s = 0;
        for (int i = 0; i < n; i++) {
            int inputNum = Integer.parseInt(br.readLine());

            if (i!=0) {
                list.add(inputNum - s);
            }
            s = inputNum;
        }

        int gcd = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            gcd = gcd(gcd, list.get(i));
        }

        int count = 0;
        for (int i = 0; i < n-1; i++) {
            count += (list.get(i) / gcd) - 1;
        }

        System.out.println(count);
    }

    private static int gcd(int a, int b) {
        if (a%b == 0) return b;
        return gcd(b, a % b);
    }
}