public class EqualPartaion {
    public static void main(String[] args) {
        int[] arr=new int[]{1,5,11,5,9,3,2};
        
        int sum=0;

        for(int x:arr) sum+=x;
    
        if(sum%2!=0) System.out.println("false");

        else{
            int size=arr.length;
            boolean[][] dp=new boolean[size+1][sum/2+1];
            equalPartition(arr, size,sum/2, dp);
            System.out.println(dp[size][sum/2]);
        }
    }

    static void equalPartition(int[] arr,int size,int sum,boolean[][] dp){

        for(int i=0;i<size+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) dp[i][j]=false;
                if(j==0) dp[i][j]=true;
            }
        }

        for(int i=1;i<size+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j) dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else dp[i][j] = dp[i-1][j]; 
            }
        }

    }
}
