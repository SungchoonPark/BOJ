import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] arr = new char[15][15];
        int max = 0;

        for(int i=0; i<5; i++) {
            arr[i] = br.readLine().toCharArray();
            if (max < arr[i].length) {
                max = arr[i].length;
            }
        }

        for(int i=0; i<max; i++) {
            for(int j=0; j<5; j++) {
                if(i+1 > arr[j].length) {
                    continue;
                } else {
                    sb.append(arr[j][i]);
                }
            }
        }

        System.out.println(sb);
    }
}

