import java.util.*;
class Solution {
    public static int solution(int[][] jobs) {
        Job[] jobArr = new Job[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            jobArr[i] = new Job(jobs[i][0], jobs[i][1]);
        }

        Arrays.sort(jobArr, Comparator.comparingInt(job -> job.arriveTime));

        Queue<Job> q = new LinkedList<>(Arrays.asList(jobArr));
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.playTime));


        int time = 0;
        int accTime = 0;
        while (!q.isEmpty() || !pq.isEmpty()) {
            while (!q.isEmpty() && q.peek().arriveTime <= time) {
                pq.offer(q.poll());
            }

            if (pq.isEmpty()) {
                time = q.peek().arriveTime;
                continue;
            }

            Job poll = pq.poll();
            accTime += time + poll.playTime - poll.arriveTime;
            time += poll.playTime;
        }

        System.out.println(accTime);
        return accTime / jobs.length;
    }
}
class Job {
    int arriveTime;
    int playTime;

    public Job(int arriveTime, int playTime) {
        this.arriveTime = arriveTime;
        this.playTime = playTime;
    }
}