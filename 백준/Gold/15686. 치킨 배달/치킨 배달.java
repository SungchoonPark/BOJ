import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    static int minChickLength = Integer.MAX_VALUE;
    static List<List<Integer>> chooseChickens;
    static int totalCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 치킨 거리 = 각 집의 치킨거리의 합
        // 도시에 있는 치킨집 최대 M개를 폐업하려하는데,
        // 어떻게 고르면 도시의 치킨 거리가 가장 작게 될까?
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        List<Chicken> chickens = new ArrayList<>();
        List<House> houses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) chickens.add(new Chicken(j, i));
                if (map[i][j] == 1) houses.add(new House(j, i));
            }
        }
        totalCount = chickens.size();
        chooseChickens = new ArrayList<>();

        comb(0, 0, m, new ArrayList<>());
        for (List<Integer> selected : chooseChickens) {
            int cityDistance = 0;


            for (House house : houses) {
                int dist = Integer.MAX_VALUE;
                for (int idx : selected) {
                    Chicken c = chickens.get(idx);
                    dist = Math.min(dist, Math.abs(c.x - house.x) + Math.abs(c.y - house.y));
                }
                cityDistance += dist;
            }

            minChickLength = Math.min(minChickLength, cityDistance);
        }
        System.out.println(minChickLength);
    }

    private static void comb(int start, int depth, int maxD, List<Integer> cs) {
        if (depth == maxD) {
            chooseChickens.add(new ArrayList<>(cs));
            return;
        }

        for (int i = start; i < totalCount; i++) {
            cs.add(i);
            comb(i + 1, depth + 1, maxD, cs);
            cs.remove(cs.size() - 1);
        }
    }

    static class Chicken {
        int x;
        int y;

        public Chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int calChickLen(House house) {
            return Math.abs(this.x - house.x) + Math.abs(this.y - house.y);
        }
    }

    static class House {
        int x;
        int y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}