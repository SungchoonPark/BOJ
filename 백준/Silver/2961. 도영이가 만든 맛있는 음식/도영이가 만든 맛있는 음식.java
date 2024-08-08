import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static int MIN = Integer.MAX_VALUE;
    static List<Ingredient> ingredients;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        ingredients = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            ingredients.add(new Ingredient(sour, bitter));
        }

        for (int i = 0; i < n; i++) {
            search(ingredients.get(i).sour, ingredients.get(i).bitter, i);
        }

        System.out.println(MIN);
    }

    private static void search(int nextSour, int nextBitter, int startIdx) {
        int curDiff = getAbs(nextSour, nextBitter);
        if (curDiff < MIN) {
            MIN = curDiff;
        }

        for (int i = startIdx + 1; i < n; i++) {
            Ingredient curIngredient = ingredients.get(i);
            search(nextSour * curIngredient.sour, nextBitter + curIngredient.bitter, i);
        }
    }

    private static int getAbs(int a, int b) {
        return Math.abs(a - b);
    }
}

class Ingredient {
    int sour;
    int bitter;

    public Ingredient(int sour, int bitter) {
        this.sour = sour;
        this.bitter = bitter;
    }

    public int getInitialDiff() {
        return Math.abs(sour - bitter);
    }
}
