import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());

        for (int i = 0; i < a; i++) {
            String str = br.readLine();

            switch (str.charAt(0)) {
                case 'a' :
                    if (str.charAt(1) == 'd') {
                        s |= (1 << (20 - Integer.parseInt(str.substring(4))));
                    } else {
                        s = (1 << 20) - 1;
                    }
                    break;
                case 'r' :
                    s &= ~(1 << (20 - Integer.parseInt(str.substring(7))));
                    break;
                case 'c' :
                    if ((s & (1 << (20 - Integer.parseInt(str.substring(6)))))>0) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case 't' :
                    s ^= (1 << (20 - Integer.parseInt(str.substring(7))));
                    break;
                case 'e' :
                    s = 0;
                    break;
            }

            
        }
        System.out.println(sb);
    }
}