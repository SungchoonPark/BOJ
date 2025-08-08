import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        long[] fibo = new long[117];
        fibo[0] = 1;
        fibo[1] = 1;
        fibo[2] = 1;
        fibo[3] = 1;

        for (int i = 4; i < fibo.length; i++) {
            fibo[i] = fibo[i - 1] + fibo[i-3];
        }

        System.out.println(fibo[n]);
    }

}