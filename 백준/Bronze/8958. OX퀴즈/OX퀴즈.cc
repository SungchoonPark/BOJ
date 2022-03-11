import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int sum = 0;
            String inputOx = br.readLine();
            int incNum = 1;

            for (int j = 0; j < inputOx.length(); j++) {
                char tmp = inputOx.charAt(j);
                if(tmp == 'O') {
                    sum += incNum;
                    incNum++;
                } else if(tmp == 'X') {
                    incNum = 1;
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
