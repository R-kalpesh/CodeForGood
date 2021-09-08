public class SubSetSum {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9};
        int sum=100;
        int size=arr.length;

        boolean[][] dp=new boolean[size+1][sum+1];

        subSetSumDP(arr, sum, size, dp);

        System.out.println(dp[size][sum]);
    }

    static void subSetSumDP(int[] arr,int sum,int size,boolean[][] dp){

        for(int i=0;i<size+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) dp[i][j]=false;
                if(j==0) dp[i][j]=true;
            }
        }

        for(int i=1;i<size+1;i++){
            for(int j=1;j<sum+1;j++){

                if(arr[i-1]<=j) dp[i][j]= dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
             
            }
        }

    }
}
