import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력받은 문자열을 첫째줄에서 입력받은 거만큼 나눠서 정수로 바꾼다음 더하면 될듯
        // 라고 생각하고 시작했지만 별로임.
        // 그냥 substring 써서 한글자씩 더해주면 매우 간단한일
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String inputNum = br.readLine();
        int sum = 0;

        for (int i =1; i<=n; i++) {
            sum += Integer.parseInt(inputNum.substring(i-1, i));
        }

        System.out.println(sum);


    }
}
