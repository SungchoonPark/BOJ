import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 홀수 - 상근 , 짝수 창영
        if(N%3 == 0) {
            int tmp = N/3;
            if(tmp % 2 == 0) {
                System.out.println("CY");
                return;
            }
            System.out.println("SK");
        } else if(N%3 == 1){
            int a = N/3;
            
            if((a+1) % 2 == 0) {
                System.out.println("CY");
                return;
            }
            System.out.println("SK");
        } else {
            int b = N/3;

            if((b+2) % 2 == 0) {
                System.out.println("CY");
                return;
            }
            System.out.println("SK");
        }


    }
}

