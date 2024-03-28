import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.Math.max;

public class Main {
    static int n;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(1);
            return;
        }
        int result = 1;

        for (int i = n; i > 0; i--) {
            result *= i;
        }
        System.out.println(result);


    }
}
