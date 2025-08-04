import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Team t1 = new Team(0, 0, 0);
        Team t2 = new Team(0, 0, 0);

        String curWin = "none";
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int teamNum = Integer.parseInt(st.nextToken());
            String time = st.nextToken();
            int curTime = calculateSecond(time);

            if (teamNum == 1) {
                t1.upScore();
            } else {
                t2.upScore();
            }

            String newWin = getCurWinner(t1, t2);
            if (curWin.equals("none") && newWin.equals("t1")) {
                curWin = "t1";
                t1.curWinTime = curTime;
            } else if (curWin.equals("none") && newWin.equals("t2")) {
                curWin = "t2";
                t2.curWinTime = curTime;
            } else if (curWin.equals("t1") && newWin.equals("none")) {
                curWin = "none";
                t1.accumulatedTime(curTime);
            } else if (curWin.equals("t2") && newWin.equals("none")) {
                curWin = "none";
                t2.accumulatedTime(curTime);
            }
        }
        String curWinner = getCurWinner(t1, t2);
        if (curWinner.equals("t1")) {
            t1.accumulatedTime(2880);
        } else if (curWinner.equals("t2")){
            t2.accumulatedTime(2880);
        }

        System.out.println(getTimeToString(t1));
        System.out.println(getTimeToString(t2));
    }

    private static int calculateSecond(String mas) {
        String[] split = mas.split(":");
        int min = Integer.parseInt(split[0]);
        int sec = Integer.parseInt(split[1]);

        return min * 60 + sec;
    }

    private static String getTimeToString(Team team) {
        int winningTime = team.winningTime;

        int min = winningTime / 60;
        int sec = winningTime % 60;

        if (min < 10 && sec >= 10) {
            return "0" + min + ":" + sec;
        } else if (min < 10 && sec < 10) {
            return "0" + min + ":0" + sec;
        } else if (min >= 10 && sec >= 10){
            return min + ":" + sec;
        } else if (min >= 10 && sec < 10) {
            return min + ":0" + sec;
        }

        return null;
    }

    private static String getCurWinner(Team t1, Team t2) {
        if (t1.score > t2.score) {
            return "t1";
        } else if (t1.score < t2.score) {
            return "t2";
        } else {
            return "none";
        }
    }
}

class Team {

    int winningTime;
    int score;
    int curWinTime;

    public Team(int winningTime, int score, int curWinTime) {
        this.winningTime = winningTime;
        this.score = score;
        this.curWinTime = curWinTime;
    }

    public void upScore() {
        this.score++;
    }

    public void accumulatedTime(int curTime) {
        this.winningTime += (curTime - curWinTime);
    }
}