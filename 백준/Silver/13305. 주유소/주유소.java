import javax.management.BadBinaryOpValueExpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        //
        int cityNum = Integer.parseInt(br.readLine());
        long lowestPrice = 0;

        long[] roadLengthList = new long[cityNum-1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cityNum-1; i++) {
            roadLengthList[i] = Long.parseLong(st.nextToken());
        }

        long[] literPriceList = new long[cityNum];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cityNum; i++) {
            literPriceList[i] = Long.parseLong(st.nextToken());
        }

        long minCost = literPriceList[0];
        for(int k=0; k<cityNum-1; k++) {
            if(literPriceList[k] < minCost) {
                minCost = literPriceList[k];
            }

            lowestPrice += (minCost*roadLengthList[k]);
        }


        System.out.println(lowestPrice);
    }
}