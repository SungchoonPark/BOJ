import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arrA = new int[100][100];
        int[][] arrB = new int[100][100];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int j = 0;
            while(st1.hasMoreTokens()) {
                arrA[i][j] = Integer.parseInt(st1.nextToken());
                j++;
            }
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int tmpM = Integer.parseInt(st2.nextToken());
        int K = Integer.parseInt(st2.nextToken());

        int[][] arrC = new int[N][K];

        for(int i=0; i<M; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int j = 0;
            while(st3.hasMoreTokens()) {
                arrB[i][j] = Integer.parseInt(st3.nextToken());
                j++;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<K; j++) {
                for(int k=0; k<M; k++) {
                    arrC[i][j] += (arrA[i][k] * arrB[k][j]);
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<K; j++) {
                System.out.printf("%d ", arrC[i][j]);
            }
            System.out.println();
        }

    }
}

