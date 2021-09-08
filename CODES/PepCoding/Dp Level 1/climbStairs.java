import java.util.Scanner;

public class climbStairs {

    
    public static void main(String[] args) {
        
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();

        int ans=tebulationDp(n);

        System.out.println(ans);
        
        scn.close();
    }

    static int recursiveDP(int n,int[] Dp){
        
        if(n<0)  return 0;

        else if(n==0)   return 1;
        
        if(Dp[n]>=0) return Dp[n];

        int oneStep=recursiveDP(n-1,Dp);          
        int twoStep=recursiveDP(n-2,Dp);
        int threeStep=recursiveDP(n-3,Dp);
        
        Dp[n] = oneStep + twoStep + threeStep;    

        return Dp[n];
    }

    static int tebulationDp(int n){

        int[] dp=new int[n+1];

    // Todo: Here small problem is N -> N only one way 
        dp[n]=1;

        for(int i=n-1;i>=0;i--){
            // we can not go out of dp arry so for evry i check && max jump is 3 if i-3<n then  no need to worry
            if(i==n-1) dp[i]=dp[i+1];
            else if(i==n-2) dp[i]=dp[i+1]+dp[i+2];
            else  dp[i]=dp[i+1]+dp[i+2]+dp[i+3];

        }

        return dp[0];
    }


}







