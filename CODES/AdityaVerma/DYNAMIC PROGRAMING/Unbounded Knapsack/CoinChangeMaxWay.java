public class CoinChangeMaxWay {
    public static void main(String[] args) {
        int[] coins=new int[]{1,2,3};
        int sum=4;

        int size=coins.length;
        int[][] dp=new int[size+1][sum+1];
        fun(coins, sum, size, dp);

        System.out.println(dp[size][sum]);

    }

    static void fun(int[] coins,int sum,int size,int[][] dp){

        for(int i=0;i<size+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) dp[i][j]=0;
                if(j==0) dp[i][j]=1;
            }
        }


        for(int i=1;i<size+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j] ;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }



    }
}
