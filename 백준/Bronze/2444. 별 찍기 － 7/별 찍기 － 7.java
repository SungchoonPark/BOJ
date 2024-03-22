import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int tmp = 2*n;
        for(int i=1; i<=2*n-1; i++) {
            if (i <= n) {
                for(int j=1; j<=n-i; j++) {
                    System.out.print(" ");
                }
                for (int j=1; j<=2*i-1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for(int j=1; j<=i-n; j++) {
                    System.out.print(" ");
                }
                for (int j=1; j<=2*(tmp-i)-1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

}