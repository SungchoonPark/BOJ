import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[100][100];
        int cnt=0;

        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j=x; j<x+10; j++) {
                for(int k=y; k<y+10; k++) {
                    if(arr[j][k] == 1) {
                        continue;
                    }
                    arr[j][k] = 1;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}

