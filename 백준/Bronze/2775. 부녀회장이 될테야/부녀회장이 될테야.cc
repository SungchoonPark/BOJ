import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[15][15];

        //층
        for(int i=0; i<15; i++) {
            // 호
            for(int j=0; j<14; j++) {
                if(i == 0) {
                    // 0층인 경우
                    arr[i][j] = j+1;
                } else {
                    // 0층이 아닌경우
                    if(j == 0) {
                        // 1호인 경우
                        arr[i][j] = 1;
                    } else {
                        // 1호가 아닌경우
                        arr[i][j] = arr[i][j-1] + arr[i-1][j];
                    }
                }
            }
        }

        for(int i=0; i<num; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[k][n-1]);
        }
    }

}

