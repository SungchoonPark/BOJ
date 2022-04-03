import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        int min = (int) Math.ceil(Math.sqrt(m));
        int max = (int) Math.floor(Math.sqrt(n));

        for(int i=min; i<=max; i++) {
            int tmp = (int) Math.pow(i, 2);
            sum += tmp;
        }
        if(sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println((int)Math.pow(min,2));
        }
    }
}

