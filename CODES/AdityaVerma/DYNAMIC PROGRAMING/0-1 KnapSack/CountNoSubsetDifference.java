public class CountNoSubsetDifference {
    public static void main(String[] args) {
        // Input
        int[] arr=new int[]{1,4,2,5};
        int diff=2;

        // Calculeting sum of arr element and Target Sum
        int sum=0;
        for(int x:arr) sum+=x;
        int targetSum=Math.abs(sum-diff)/2;
        int size=arr.length;

        // Creating Dp Table for [size+1][targetSum+1]
        int[][] dp=new int[size+1][targetSum+1];

        //  Calling subSetSumDP function 
        subSetSumDP(arr, targetSum, size, dp);

        // Abstrecting ans
        int ans=dp[size][targetSum];
        System.out.println(ans);
    }

    static void subSetSumDP(int[] arr,int sum,int size,int[][] dp){

        for(int i=0;i<size+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) dp[i][j]=0;
                if(j==0) dp[i][j]=1;
            }
        }

        for(int i=1;i<size+1;i++){
            for(int j=1;j<sum+1;j++){

                if(arr[i-1]<=j) dp[i][j]= dp[i-1][j-arr[i-1]] + dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
             
            }
        }

    }
}
