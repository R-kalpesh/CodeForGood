
public class RodCutting {
    public static void main(String[] args) {
        // INPUT ######################
        int[] price=new int[]{5,4,6,16,10};
        int[] length=new int[]{1,2,3,4,5};
        int maxLength=8;


        // Creating dp table and calling fun
        int size=price.length;
        int[][] dp=new int[size+1][maxLength+1];
        knapsackDP(length, price, maxLength, size, dp);

        // OutPut
        System.out.println(dp[size][maxLength]);
    }

    static void knapsackDP(int[] length,int[] price,int maxLength,int size,int[][] Dp){

        for(int i=0;i<size+1;i++){
            for(int j=0;j<maxLength+1;j++){
                if(i==0 || j==0) Dp[i][j]=0; 
            }
        }

        for(int i=1;i<size+1;i++){
            for(int j=1;j<maxLength+1;j++){
                if(length[i-1]<=j) Dp[i][j]= Math.max(price[i-1]+Dp[i][j-length[i-1]] , Dp[i-1][j]);
                else Dp[i][j]=Dp[i-1][j]; 
            }
        }
    }
}
