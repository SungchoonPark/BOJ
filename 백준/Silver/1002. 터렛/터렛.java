import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if(x1==x2 && y1==y2 && r1 == r2) {
                System.out.println(-1);
            } else {
                int length = (int) (Math.pow(x1-x2, 2)+Math.pow(y2-y1,2));

                if(length == Math.pow(r2-r1,2)) {
                    System.out.println(1);
                } else if (length < Math.pow(r2-r1,2)) {
                    System.out.println(0);
                } else if (length > Math.pow(r1+r2,2)) {
                    System.out.println(0);
                } else if (length < Math.pow(r1+r2,2)) {
                    System.out.println(2);
                } else if (length == Math.pow(r1+r2,2)) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
            }
        }


    }
}
