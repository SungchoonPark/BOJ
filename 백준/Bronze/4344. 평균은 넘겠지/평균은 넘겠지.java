import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int c= sc.nextInt();
        
        for(int i =0; i<c; i++) {
            int[] n = new int[sc.nextInt()];
            int sum=0;
            int avg=0;
            int cnt=0;
            float stAvg = 0;
            
            for(int j=0; j<n.length; j++) {
                n[j] = sc.nextInt();
                sum += n[j];
            }
            
            avg = sum/(n.length);
            
            for(int k=0; k<n.length; k++) {
                if(n[k] > avg){
                    cnt++;
                }
            }
            
            stAvg = (float) cnt/n.length*100;
      
            System.out.println(String.format("%.3f", stAvg)+"%");
        }
    }
}

