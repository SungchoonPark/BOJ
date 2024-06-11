import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int maxX = -10001;
        int minX = 10001;
        int maxY = -10001;
        int minY = 10001;
        for(int i=0; i<a; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x > maxX) maxX = x;
            if(x < minX) minX = x;
            if(y > maxY) maxY = y;
            if(y < minY) minY = y;
        }
        int tmpX = maxX - minX;
        int tmpY = maxY - minY;
        System.out.println(tmpX * tmpY);
    }
}
