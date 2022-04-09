import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int i=0; i<10; i++) {
            int tmp = sum;
            int num = Integer.parseInt(br.readLine());
            sum += num;

            if(sum >= 100) {
                if(100 - tmp == sum - 100) {
                    System.out.println(sum);
                    return;
                } else {
                    int result = 100 - tmp > sum - 100 ? sum : tmp;
                    System.out.println(result);
                    return;
                }
            }
        }
        System.out.println(sum);
    }
}

