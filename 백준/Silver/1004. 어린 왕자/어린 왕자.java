import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            List<Planet> planets = new ArrayList<>();

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int planetCnt = Integer.parseInt(br.readLine());

            for (int j = 0; j < planetCnt; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                planets.add(new Planet(x, y, r));
            }

            // 출발지점 포함하는 행성 개수
            int startInclude = 0;
            for (Planet planet : planets) {
                if (planet.isInclude(x1, y1)) startInclude++;
            }

            int endInclude = 0;
            for (Planet planet : planets) {
                if (planet.isInclude(x2, y2)) endInclude++;
            }

            int totalInclude = 0;
            for (Planet planet : planets) {
                if (planet.isInclude(x1, y1) && planet.isInclude(x2, y2)) totalInclude += 2;
            }

            int result = startInclude + endInclude - totalInclude;
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static class Planet {
        int x;
        int y;
        int r;

        public Planet(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public boolean isInclude(int x1, int y1) {
            int l = (int) Math.pow((x - x1), 2) + (int) Math.pow((y - y1), 2);

            return Math.pow(r, 2) >= l;
        }
    }

}