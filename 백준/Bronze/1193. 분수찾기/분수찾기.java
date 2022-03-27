import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int prevSum = 0;
        int cnt=1;

        while(true) {
            if(num <= prevSum + cnt) {
                if(cnt %2 == 0) {
                    // 짝수인 경우
                    System.out.println((num - prevSum) + "/" + (cnt - (num - prevSum - 1)));
                    break;
                } else {
                    // 홀수인 경우
                    System.out.println(cnt - (num - prevSum - 1) + "/" + (num - prevSum));
                    break;
                }
            } else {
                prevSum += cnt;
                cnt++;
            }
        }
    }
}

