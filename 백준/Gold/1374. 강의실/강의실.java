import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int lecturNum = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[lecturNum];

        for (int i = 0; i < lecturNum; i++) {
            st = new StringTokenizer(br.readLine());
            int lN = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(lN, startTime, endTime);
        }
        Arrays.sort(lectures, Comparator.comparingInt(l -> l.startTime));

        Queue<Lecture> q = new LinkedList<>(Arrays.asList(lectures));
        PriorityQueue<Lecture> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.endTime));

        int classNum = 1;
        while (!q.isEmpty()) {
            if (pq.isEmpty()) {
                pq.offer(q.poll());
            } else {
                if (q.peek().startTime < pq.peek().endTime) {
                    classNum++;
                    pq.offer(q.poll());
                } else {
                    pq.poll();
                    pq.offer(q.poll());
                }
            }
        }

        System.out.println(classNum);
    }
}

class Lecture {
    int lectureNumber;
    int startTime;
    int endTime;

    public Lecture(int lectureNumber, int startTime, int endTime) {
        this.lectureNumber = lectureNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}