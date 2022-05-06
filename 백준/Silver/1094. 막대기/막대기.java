import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int cnt = 0;
        int len = 64;

        while(X > 0) {
            // 스틱의 길이가 x보다 크면 절반으로 자르기
            if(len > X) {
                len /= 2;
            } else {
                cnt++;
                X -= len;
            }
        }

        System.out.println(cnt);
    }
}

