import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int toChannel = Integer.parseInt(br.readLine());
        int breakButtonNum = Integer.parseInt(br.readLine());
        // true면 고장남, false면 안고장남
        boolean[] breaks = new boolean[10];
        if (breakButtonNum != 0) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                breaks[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // 이건 +, - 로만 가는 방법의 수
        int result = Math.abs(toChannel - 100);

        // 이게 이제 제일 근접한 수로 가서 +, - 해보는거
        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);

            boolean flag = false;
            for (int j = 0; j < s.length(); j++) {
                if (breaks[s.charAt(j) - '0']) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                // 여기서 s.length()를 더해주는 이유는 버튼을 누른 횟수이기 때문
                int tmp = Math.abs(i - toChannel) + s.length();
                result = Math.min(result, tmp);
            }
        }

        System.out.println(result);
    }
}