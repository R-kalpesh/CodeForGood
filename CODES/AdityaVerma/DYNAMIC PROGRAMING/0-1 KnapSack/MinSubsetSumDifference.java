import java.util.ArrayList;

public class MinSubsetSumDifference {
    public static void main(String[] args) {
        // INPUT  
        int[] arr=new int[]{1, 6, 11, 5};

        // Caluleting sum and size of given array
        int sum=0;
        for(int x:arr) sum+=x;
        int size=arr.length;

        // Creating Dp Table of size [size+1][sum+1]
        boolean[][] dp=new boolean[size+1][sum+1];

        // Calling fun
        subSetSumDP(arr, size, sum, dp);

        // Feaching data from Last row of the Dp Table if sum is possible 
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<=sum/2;i++){  // i<=sum/2 important travel only half other wise afterwards Abs diffrance will in -ve
            if(dp[size][i]==true){
                list.add(i);
            }
        }

        // Now taking Min of (SumOfArraysElement - (2*list element))
        int ans=Integer.MAX_VALUE;
        for(int x:list){
            ans=Math.min(ans, sum-2*x);
        }
        System.out.println(ans);

    }


    static void subSetSumDP(int[] arr,int size,int sum,boolean[][] dp){

        for(int i=0;i<size+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) dp[i][j]=false;
                if(j==0) dp[i][j]=true;
            }
        }


        for(int i=1;i<size+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j]  ;
                }else{
                    dp[i][j]= dp[i-1][j] ;
                }
            }
        }


    }
}
