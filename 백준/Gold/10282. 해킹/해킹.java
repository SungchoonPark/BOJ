import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < testNum; i++) {

            st = new StringTokenizer(br.readLine());

            int computerCount = Integer.parseInt(st.nextToken());
            int dependencyCount = Integer.parseInt(st.nextToken());
            int hackedComputerNum = Integer.parseInt(st.nextToken());

            int[] cost = new int[computerCount + 1];
            Arrays.fill(cost, Integer.MAX_VALUE);
            List<Computer>[] computers = new List[computerCount + 1];
            for (int j = 0; j < computerCount + 1; j++) {
                computers[j] = new ArrayList<>();
            }

            for (int j = 0; j < dependencyCount; j++) {
                st = new StringTokenizer(br.readLine());

                int computerA = Integer.parseInt(st.nextToken());
                int computerB = Integer.parseInt(st.nextToken());
                int infectionTime = Integer.parseInt(st.nextToken());

                computers[computerB].add(new Computer(computerA, infectionTime));
            }

            dijkstra(hackedComputerNum, computers, cost);
        }

        System.out.print(sb);
    }

    private static void dijkstra(int hackedComputerNum, List<Computer>[] computers, int[] cost) {
        PriorityQueue<Computer> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.time));
        pq.offer(new Computer(hackedComputerNum, 0));

        cost[hackedComputerNum] = 0;
        int infectionComputerNum = 1;
        int totalInfectionTime = 0;

        while(!pq.isEmpty()) {
            Computer curComputer = pq.poll();

            if (cost[curComputer.num] < curComputer.time) {
                continue;
            }

            for (Computer nextComputer : computers[curComputer.num]) {
                if (cost[nextComputer.num] > cost[curComputer.num] + nextComputer.time) {
                    if (cost[nextComputer.num] == Integer.MAX_VALUE) infectionComputerNum++;
                    cost[nextComputer.num] = cost[curComputer.num] + nextComputer.time;
                    pq.offer(nextComputer);
                }
            }
        }

        for (int i : cost) {
            if (i == Integer.MAX_VALUE) continue;
            totalInfectionTime = Math.max(totalInfectionTime, i);
        }

        sb.append(infectionComputerNum).append(" ").append(totalInfectionTime).append("\n");
    }

    static class Computer {
        int num;
        int time;

        public Computer(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}