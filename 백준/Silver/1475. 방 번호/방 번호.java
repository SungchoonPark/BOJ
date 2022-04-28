import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 한 상자에 0~9 까지 플라스틱 카드가 하나씩 들어있음
        // 6과 9는 서로 바꿔 쓸 수 있음
        char[] arr = br.readLine().toCharArray();
        int[] numArr = new int[10];
        for (char c : arr) {
            numArr[c - 48]++;
        }

        int tmp = (numArr[6] + numArr[9]);

        if( tmp % 2 == 0) {
            numArr[6] = tmp/2;
            numArr[9] = tmp/2;
        } else {
            numArr[6] = tmp/2+1;
            numArr[9] = tmp/2+1;
        }

        int max = 0;
        for (int i : numArr) {
            if(i > max) {
                max = i;
            }
        }

        System.out.println(max);
    }
}

