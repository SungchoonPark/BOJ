import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        int i=0;
        while(st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        int radius = arr[0];

        for(int j=1; j<arr.length; j++) {
            int gcd = getGCD(radius, arr[j]);
            sb.append(radius/gcd).append("/").append(arr[j]/gcd).append("\n");
        }

        System.out.println(sb);

    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }
}
