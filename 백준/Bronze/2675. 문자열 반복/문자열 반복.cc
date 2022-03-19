import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++) {
            String[] s = br.readLine().split(" ");
            int repeat = Integer.parseInt(s[0]);
            char[] inputS = s[1].toCharArray();

            for(int j = 0; j < inputS.length; j++) {
                for(int k = 0; k < repeat; k++) {
                    sb.append(inputS[j]);
                }
            }
            System.out.println(sb);
            sb.delete(0,sb.length());
        }

    }
}
