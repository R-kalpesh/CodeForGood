import java.util.Arrays;

public class knapsack {
    public static void main(String[] args) {
        
        // I/P===========================================================================
        int[] val=new int[]{60,100,120};
        int[] weight=new int[]{10,20,30};
        int W=50;
        int size=val.length;

        // Memoization===================================================================
        int[][] Memo = new int[W][size];
        for (int[] row : Memo) 
            Arrays.fill(row, -1);


        // Dynamic =======================================================================
        int[][] Dp = new int[size+1][W+1];

        
        
        knapsackDP(weight, val, W, size,Dp);
        System.out.println(Dp[size][W]);
        

    }

    static int knapsackRecursive(int[] weight,int[] val,int W,int size){
        
        if(W==0 || size==0 ) return 0;

        if(weight[size-1]<=W){
            return Math.max(val[size-1]+knapsackRecursive(weight, val, W-weight[size-1], size-1),knapsackRecursive(weight, val, W, size-1));
        }else{
            return knapsackRecursive(weight, val, W, size-1);
        } 

    }

    static int knapsackMemoization(int[] weight,int[] val,int W,int size,int[][] dp){
        
        if(W==0 || size==0 ) return 0;


        if(dp[weight[size-1]][size-1]!=-1){
            return dp[weight[size-1]][size-1];
        }

        if(weight[size-1]<=W){
            return dp[weight[size-1]][size-1]=Math.max(val[size-1]+knapsackMemoization(weight, val, W-weight[size-1], size-1,dp),knapsackMemoization(weight, val, W, size-1,dp));
        }else{
            return dp[weight[size-1]][size-1]=knapsackMemoization(weight, val, W, size-1,dp);
        } 

    }

    static void knapsackDP(int[] weight,int[] val,int W,int size,int[][] Dp){

        for(int i=0;i<size+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0 || j==0) Dp[i][j]=0; 
            }
        }

        for(int i=1;i<size+1;i++){
            for(int j=1;j<W+1;j++){
                if(weight[i-1]<=j) Dp[i][j]= Math.max(val[i-1]+Dp[i-1][j-weight[i-1]] , Dp[i-1][j]);
                else Dp[i][j]=Dp[i-1][j]; 
            }
        }
    }

}
