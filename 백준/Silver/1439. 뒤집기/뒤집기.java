import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        char[] num = S.toCharArray();

        int zero = 0;
        int one = 0;

        for(int i=0; i<num.length; i++) {
            if(i > 0) {
                if(num[i] - '0' == 0) {
                    if(num[i-1] - '0' != 0) {
                        zero++;
                    }
                } else {
                    if(num[i-1] - '0' != 1) {
                        one++;
                    }
                }
            } else {
                if(num[i] - '0' == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
        }

        int result = Math.min(zero, one);
        System.out.println(result);
    }
}

