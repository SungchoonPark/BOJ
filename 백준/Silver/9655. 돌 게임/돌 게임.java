import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int tmp = N/3;
        // 홀수 - 상근 , 짝수 창영
        if(N%3 == 0) {
            print(tmp);
        } else if(N%3 == 1){
            print(tmp+1);
        } else {
            print(tmp+2);
        }
    }

    public static void print(int n) {
        StringBuilder sb = new StringBuilder();
        if(n % 2 == 0) {
            sb.append("CY");
        } else {
            sb.append("SK");
        }
        System.out.println(sb);
    }
}

