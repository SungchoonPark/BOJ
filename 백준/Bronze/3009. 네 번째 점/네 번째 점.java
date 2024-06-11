import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int[] arrX = new int[1001];
        int[] arrY = new int[1001];
        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrX[x]++;
            arrY[y]++;
            if (!listX.contains(x)) {
                listX.add(x);
            }
            if (!listY.contains(y)) {
                listY.add(y);
            }
        }

        for(int i=0; i< listX.size(); i++) {
            Integer i1 = listX.get(i);
            if(arrX[i1] == 1) sb.append(i1).append(" ");
        }
        for(int i=0; i< listX.size(); i++) {
            Integer i1 = listY.get(i);
            if(arrY[i1] == 1) sb.append(i1).append(" ");
        }
        System.out.println(sb);
    }
}
