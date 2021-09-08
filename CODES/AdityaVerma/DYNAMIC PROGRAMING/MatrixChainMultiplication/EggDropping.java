import java.util.Arrays;
import java.util.HashMap;

public class EggDropping {
    public static void main(String[] args) {
        int K = 3, N = 5;

        int[][] memo = new int[K + 1][N + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int ans = funMemo(K, N, memo);
        System.out.println(ans);
    }

    static int fun(int egg, int floor) {
        if (floor == 0 || floor == 1)
            return floor;

        if (egg == 1)
            return floor;

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= floor; k++) {

            int temp = 1 + Math.max(fun(egg - 1, k - 1), fun(egg, floor - k));

            if (min > temp)
                min = temp;
        }
        return min;
    }

    static int funMemo(int egg, int floor, int[][] memo) {
        if (floor == 0 || floor == 1)
            return floor;

        if (egg == 1)
            return floor;

        if (memo[egg][floor] != -1)
            return memo[egg][floor];

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= floor; k++) {

            int down, top;

            if (memo[egg - 1][k - 1] != -1) {
                down = memo[egg - 1][k - 1];
            } else {
                down = funMemo(egg - 1, k - 1, memo);
            }

            if (memo[egg][floor - k] != -1) {
                top = memo[egg][floor - k];
            } else {
                top = funMemo(egg, floor - k, memo);
            }

            int temp = 1 + Math.max(down, top);

            if (min > temp)
                min = temp;
        }
        memo[egg][floor] = min;
        return min;
    }

    static HashMap<String, Integer> map = new HashMap<>();

    static int funDp(int egg, int floor) {
        if (floor == 0 || floor == 1)
            return floor;

        if (egg == 1)
            return floor;

        if (map.containsKey(egg + "_" + floor))
            return map.get(egg + "_" + floor);

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= floor; k++) {
            int down, top;

            if (map.containsKey((egg - 1) + "_" + (k - 1))) {
                down = map.get((egg - 1) + "_" + (k - 1));
            } else {
                down = funDp(egg - 1, k - 1);
            }

            if (map.containsKey((egg) + "_" + (floor - k))) {
                top = map.get((egg) + "_" + (floor - k));
            } else {
                top = funDp(egg, floor - k);
            }

            int temp = 1 + Math.max(down, top);

            if (min > temp)
                min = temp;
        }
        map.put(egg + "_" + floor, min);
        return min;
    }
}
