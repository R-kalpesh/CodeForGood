import java.util.Arrays;

public class MinCost {
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 20, 30, 40, 30 };

        int[][] dp=new int[arr.length+1][arr.length+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        int ans = memo(arr, 1, arr.length-1,dp );
        System.out.println(ans);
    }

    static int fun(int[] arr, int i, int j) {
        if (i >= j)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k <j; k++) {
            int tempAns = fun(arr, i, k) + fun(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);

            if (min > tempAns)
                min = tempAns;
        }

        return min;
    }


    static int memo(int[] arr,int i, int j,int[][] dp){
        if (i >= j) return 0;
            
        if(dp[i][j]!=-1) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k <j; k++) {
            int tempAns = memo(arr, i, k,dp) + memo(arr, k + 1, j,dp) + (arr[i - 1] * arr[k] * arr[j]);

            if (min > tempAns)  min = tempAns;
        }

        dp[i][j]=min;
        
        return min;
    }
}
