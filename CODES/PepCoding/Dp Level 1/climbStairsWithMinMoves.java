import java.util.Scanner;

public class climbStairsWithMinMoves {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();

        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }

        Integer[] dp=new Integer[n+1];

        // todo: for last stair there is only one way and that is just stay there.
        dp[n]=0;

        for(int i=n-1;i>=0;i--){
            
            if(arr[i]>0){

                int min=Integer.MAX_VALUE;
                
                for(int j=1;j <= arr[i] && i+j<dp.length;j++){
                    if(dp[i+j]!=null) {
                        min=Math.min(dp[i+j],min);
                    }
                }
                // min!=Integer.MAX_VALUE then add one to min & store in dp 
                if(min!=Integer.MAX_VALUE){
                    dp[i]=min+1;
                }

            }
            
        }

        System.out.println(dp[0]);
        scn.close();
    }
}
