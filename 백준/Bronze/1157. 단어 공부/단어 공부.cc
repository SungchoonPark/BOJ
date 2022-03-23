import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        String newStr = str.toUpperCase();

        int[] alpha = new int[26];

        for(int i=0; i<newStr.length(); i++) {
            int n = newStr.charAt(i);
            alpha[n-65]++;
        }

        int max = 0;
        int maxIndex = 0;
        int tmp = 0;

        for(int i=0; i<alpha.length; i++) {
            if(alpha[i] > max) {
                max = alpha[i];
                maxIndex = i;
                tmp = 0;
            } else if(alpha[i] == max) {
                tmp++;
            }
        }
        
        if(tmp != 0) {
            System.out.println("?");
        } else {
            char c = (char)(maxIndex+65);
            System.out.println(c);
        }

    }
}
