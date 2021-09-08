public class MinNoOfInserstionToMakePalindrome {
    public static void main(String[] args) {

        String x="acbcbda";

        StringBuilder y=new StringBuilder(x);
        y.reverse();

        int xlen=x.length();
        int ylen=y.length();

        int[][] dp=new int[xlen+1][ylen+1];
        
        lcsDp(x, y.toString(), xlen, ylen,dp);

        int lcsLength=dp[xlen][ylen];

        int ans=xlen-lcsLength;
        System.out.println(ans);
    }



    static void lcsDp(String x,String y,int xLength,int yLength,int[][] dp){

        for(int i=0;i<xLength+1;i++){
            for(int j=0;j<yLength+1;j++){
                if(i==0 || j==0) dp[i][j]=0;
            }
        }


        for(int i=1;i<xLength+1;i++){

            for(int j=1;j<yLength+1;j++){

                if(x.charAt(i-1)==y.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];

                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);

            }
        }

    }

}