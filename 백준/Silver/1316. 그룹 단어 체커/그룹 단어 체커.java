import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            char[] arr = str.toCharArray();
            int flag = 1;

            for (int j = 0; j < str.length(); j++) {
                for (int k = j + 1; k < str.length(); k++) {
                    if (arr[j] == arr[k]) {
                        if (arr[k - 1] != arr[j]) {
                            flag = 0;
                            break;
                        }
                    }
                }
                if (flag == 0) {
                    break;
                }
            }

            if(flag == 1) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

