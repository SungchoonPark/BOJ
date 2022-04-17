import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int tmp = num;

        for(int i=0; i<num; i++) {
            int[] alpha = new int[26];
            String str = br.readLine();

            for(int j=1; j<str.length(); j++) {
                if(str.charAt(j-1) != str.charAt(j)) {
                    if(alpha[str.charAt(j)-'a'] == 1) {
                        tmp--;
                        break;
                    }
                    alpha[str.charAt(j-1) - 'a'] = 1;
                }
            }
        }
        System.out.println(tmp);

    }
}

