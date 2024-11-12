import java.io.*;
import java.util.*;

public class Solution {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;
            while(n != 1) {
                if (n % 2 == 0) {
                    a++;
                    n /= 2;
                } else if (n % 3 == 0) {
                    b ++;
                    n /= 3;
                } else if (n % 5 == 0) {
                    c++;
                    n /= 5;
                } else if (n % 7 == 0) {
                    d++;
                    n /= 7;
                } else if (n % 11 == 0) {
                    e++;
                    n /= 11;
                }
            }


            System.out.println("#" + (i+1) + " " + a  + " " + b + " " + c + " " + d + " " + e);
        }
    }
}