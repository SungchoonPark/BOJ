import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inpNum = Integer.parseInt(br.readLine());

        int cnt = 0;
        int num = inpNum;

        do {
            inpNum = ((inpNum%10) * 10) + (((inpNum/10) + (inpNum%10)) %10);
            cnt++;
        } while (num != inpNum);

        System.out.println(cnt);
    }
}
