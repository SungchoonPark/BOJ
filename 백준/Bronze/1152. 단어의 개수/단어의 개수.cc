import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int count = 0;
        int preCh = 32; // 아스키 코드 32는 공백문자를 뜻함
        int str;
        while(true) {
            str = System.in.read();

            if (str == 32) { // 공백인 경우
                if(preCh != 32) count++; // 문자열이 공백으로 시작한 경우는 count x
            } else if (str == 10) { // /n 인 경우
                if(preCh != 32) count++; // 문자열이 공백으로 끝난 경우 count x
                break;
            }

            preCh = str;
        }

        System.out.println(count);
    }
}
