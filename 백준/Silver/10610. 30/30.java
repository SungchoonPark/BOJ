import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String num = br.readLine();
        int sum = 0;
        char[] arr = num.toCharArray();
        Arrays.sort(arr);
        int len = num.length();

        for(int i=len-1; i>=0; i--) {
            int n = arr[i] - '0';
            sum += n;
            sb.append(n);
        }

        if(arr[0] != '0' || sum%3 != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb);
    }
}

