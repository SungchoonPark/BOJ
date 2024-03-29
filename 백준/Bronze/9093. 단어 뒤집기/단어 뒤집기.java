import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String s = st.nextToken();
                StringBuffer strBuff = new StringBuffer(s);
                String reverse = strBuff.reverse().toString();
                sb.append(reverse).append(" ");
            }
            System.out.println(sb);
        }
    }
}

