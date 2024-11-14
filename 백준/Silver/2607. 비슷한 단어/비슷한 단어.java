import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        String pivotStr = br.readLine();

        for (String s : pivotStr.split("")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            set.add(s);
        }

        int result = 0;
        for (int i = 1; i < n; i++) {
            List<String> list = new ArrayList<>();
            Map<String, Integer> tmpMap = new HashMap<>();
            Set<String> tmpSets = new HashSet<>();
            String tmp = br.readLine();
            if (pivotStr.length() + 1 < tmp.length() || tmp.length() < pivotStr.length() - 1) continue;

            for (String s : tmp.split("")) {
                tmpMap.put(s, tmpMap.getOrDefault(s, 0) + 1);
                tmpSets.add(s);
            }
            tmpSets.addAll(set);

            int diffCnt = 0;
            for (String s : tmpSets) {
                Integer pivotCnt = map.getOrDefault(s, 0);
                Integer tmpCnt = tmpMap.getOrDefault(s, 0);
                int value = Math.abs(pivotCnt - tmpCnt);
                if (value == 1) list.add(s);
                diffCnt += value;
            }

            if (diffCnt < 2) {
                result++;
            } else if (diffCnt == 2 && list.size() == 2) {
                result++;
            }
        }
        System.out.println(result);
    }
}