public class CoinChangeMinCoins {
    public static void main(String[] args) {
        int[] coins=new int[]{25, 10, 5};
        int sum=30;

        int size=coins.length;
        int[][] dp=new int[size+1][sum+1];
        // fun(coins, sum, size, dp);

        System.out.println(dp[size][sum]);


        System.out.println(Math.min(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    static void fun(int[] coins,int sum,int size,int[][] dp){

        // Initlization is diffrind this time
        for(int i=0;i<size+1;i++){
            for(int j=0;j<sum+1;j++){
                if(j==0) dp[i][j]=0;
                if(i==0) dp[i][j]=Integer.MAX_VALUE-1;
            }
        }

        for(int i=1;i<size+1;i++){
            for(int j=1;j<sum+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]] , dp[i-1][j] );
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }

}
