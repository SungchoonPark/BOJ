import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static Wheel[] wheels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        wheels = new Wheel[5];
        for (int i = 0; i < 4; i++) {
            char[] wheelStatus = br.readLine().toCharArray();
            wheels[i + 1] = new Wheel(wheelStatus, i + 1);
        }

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int moveWheelNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            boolean isSameOneAndTwo = isSame(1, 2);
            boolean isSameTwoAndThree = isSame(2, 3);
            boolean isSameThreeAndFour = isSame(3, 4);

            int[] rotate = new int[5];
            rotate[moveWheelNum] = dir;

            if (moveWheelNum == 1) {
                if (!isSameOneAndTwo) {
                    rotate[2] = -dir;
                    if (!isSameTwoAndThree) {
                        rotate[3] = dir;
                        if (!isSameThreeAndFour) {
                            rotate[4] = -dir;
                        }
                    }
                }
            } else if (moveWheelNum == 2) {
                if (!isSameOneAndTwo) rotate[1] = -dir;
                if (!isSameTwoAndThree) {
                    rotate[3] = -dir;
                    if (!isSameThreeAndFour) rotate[4] = dir;
                }
            } else if (moveWheelNum == 3) {
                if (!isSameTwoAndThree) {
                    rotate[2] = -dir;
                    if (!isSameOneAndTwo) rotate[1] = dir;
                }
                if (!isSameThreeAndFour) rotate[4] = -dir;
            } else {
                if (!isSameThreeAndFour) {
                    rotate[3] = -dir;
                    if (!isSameTwoAndThree) {
                        rotate[2] = dir;
                        if (!isSameOneAndTwo) rotate[1] = -dir;
                    }
                }
            }

            // ✅ 모든 회전은 여기서 한 번에 처리 (초기 상태 기반)
            for (int w = 1; w <= 4; w++) {
                if (rotate[w] != 0) move(w, rotate[w]);
            }
        }

        int result = 0;
        for (int i = 1; i <= 4; i++) {
            result += wheels[i].getScore();
        }

        System.out.println(result);
    }

    private static void move(int wheelNum, int dir) {
        if (dir == 1) {
            wheels[wheelNum].moveTime();
        } else {
            wheels[wheelNum].moveReverseTime();
        }
    }

    private static boolean isSame(int w1, int w2) {
        return wheels[w1].getThreeTime() == wheels[w2].getNineTime();
    }

    static class Wheel {
        int[] timeStatus = new int[8]; // ✅ 8칸만 사용
        int number;

        public Wheel(char[] times, int number) {
            for (int i = 0; i < 8; i++) {
                timeStatus[i] = times[i] - '0';
            }
            this.number = number;
        }

        public void moveTime() { // ✅ 시계 방향
            int last = timeStatus[7];
            for (int i = 7; i > 0; i--) {
                timeStatus[i] = timeStatus[i - 1];
            }
            timeStatus[0] = last;
        }

        public void moveReverseTime() {
            int first = timeStatus[0];
            for (int i = 0; i < 7; i++) {
                timeStatus[i] = timeStatus[i + 1];
            }
            timeStatus[7] = first;
        }

        public int getThreeTime() { return timeStatus[2]; }
        public int getNineTime() { return timeStatus[6]; }

        public int getScore() {
            if (timeStatus[0] == 0) return 0;
            return (1 << (number - 1));
        }
    }
}