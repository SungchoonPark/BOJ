import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder를 사용하여 출력을 해야 시간이 더욱 감축되네용
        StringBuilder sb = new StringBuilder();
        int value = Integer.parseInt(br.readLine());

        for(int i =1; i<=value; i++) {
            sb.append(i).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}
