import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> parties = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int result = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int trustParent = Integer.MAX_VALUE;
        
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int trustNum = Integer.parseInt(st.nextToken());
        if (trustNum == 0) {
            System.out.print(m);
            return;
        }

        int prevNum = -1;
        for (int i = 0; i < trustNum; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (i != 0) union(arr, prevNum, tmp);
            trustParent = Math.min(trustParent, tmp);
            prevNum = tmp;
        }

        // union
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pp = Integer.parseInt(st.nextToken());
            List<Integer> tmpList= new ArrayList<>();
            int pn = -1;
            for (int j = 0; j < pp; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (j != 0) union(arr, pn, tmp);
                tmpList.add(tmp);
                pn = tmp;
            }
            parties.add(tmpList);
        }
        
        int finalTP = find(arr, trustParent);
        // find 해서 정답 구하기

        for (List<Integer> party : parties) {
            boolean flag = false;
            for (Integer i : party) {
                if (find(arr, i) == finalTP) {
                    flag = true;
                    break;
                }
            }
            if (!flag) result++;
        }

        System.out.print(result);
    }

    private static int find(int[] arr, int n) {
        if (arr[n] == n) return n;
        return arr[n] = find(arr, arr[n]);
    }

    private static void union(int[] arr, int a, int b) {
        int ap = find(arr, a);
        int bp = find(arr, b);

        if(ap < bp) arr[bp] = ap;
        else arr[ap] = bp;
    }
}
