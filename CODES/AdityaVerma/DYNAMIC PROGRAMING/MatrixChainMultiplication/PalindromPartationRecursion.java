
import java.util.Arrays;
import java.util.Scanner;

public class PalindromPartationRecursion {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();

        int[][] dp = new int[str.length() + 1][str.length() + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // int ans = minPartation(str, 0, str.length() - 1);

        int ans = minPartationDp(str, 0, str.length() - 1, dp);

        System.out.println(ans);

    }

    static int minPartation(String str, int i, int j) {
        if (i >= j)
            return 0;

        if (isPalin(str, i, j) == true)
            return 0;

        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int tempAns = minPartation(str, i, k) + minPartation(str, k + 1, j) + 1;

            if (min > tempAns) {
                min = tempAns;
            }
        }

        return min;
    }

    static int minPartationDp(String str, int i, int j, int[][] dp) {

        if (i >= j || isPalin(str, i, j) == true)

            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {

            int left, right;

            if (dp[i][k] != -1) {
                left = dp[i][k];
            } else {
                left = minPartationDp(str, i, k, dp);
            }

            if (dp[k + 1][j] != -1) {
                right = dp[k + 1][j];
            } else {
                right = minPartationDp(str, k + 1, j, dp);
            }

            int tempAns = left + right + 1;

            if (min > tempAns)
                min = tempAns;
        }

        dp[i][j] = min;
        return min;
    }

    static boolean isPalin(String str, int i, int j) {

        String prob = str.substring(i, j + 1);

        StringBuilder rev = new StringBuilder(prob);

        rev.reverse();

        if (prob.equals(rev.toString()))
            return true;

        return false;

    }
}