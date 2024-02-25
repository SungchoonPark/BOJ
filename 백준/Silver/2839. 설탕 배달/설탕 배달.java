import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static StringTokenizer st;
    private static int[] arr;
    private static int n, bag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        while (n >= 3) {
            if(n % 5 == 0) {
                bag = bag + (n/5);
                n = 0;
                break;
            } else {
                n -= 3;
                bag++;
            }
        }

        if (n == 0) System.out.println(bag);
        else System.out.println(-1);
    }
}


