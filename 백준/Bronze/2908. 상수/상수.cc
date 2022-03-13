import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1번 풀이
public class Main {

    public static void main(String[] args) throws IOException {

       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> list = new ArrayList<>();
        List<String> newList = new ArrayList<>();


        while(st.hasMoreTokens()) {
            list.add(st.nextToken());
        }

        for(String s : list) {
            String rStr = "";
            for(int i = 2; i>=0; i--) {
                rStr += s.charAt(i);
            }
            newList.add(rStr);
        }

        String bigger = (Integer.parseInt(newList.get(0)) > Integer.parseInt(newList.get(1))) ? newList.get(0) : newList.get(1);

        System.out.println(bigger);

        br.close();
    }
}

// 2번 풀이
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int[] A = new int[3];
        int[] B = new int[3];

        for(int i = 0; i < 3; i++) {
            A[i] = System.in.read()-'0';
        }
        System.in.read();
        for(int i = 0; i < 3; i++) {
            B[i] = System.in.read()-'0';
        }
	    
        int tA = A[0] + A[1]*10 + A[2]*100;
        int tB = B[0] + B[1]*10 + B[2]*100;
	    
        System.out.println(tA>tB?tA:tB);

    }
}


