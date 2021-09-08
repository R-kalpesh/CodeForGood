public class LongestReapetingSubSequnce {

    public static void main(String[] args) {

        StringBuilder ans = new StringBuilder();

        String x="nnpxouomcofdjuujloanjimymadkuepightrfodmauhrsy";

        int xlen=x.length();
        
        int[][] dp=new int[xlen+1][xlen+1];

        for(int i=0;i<=xlen;i++){

            for(int j=0;j<=xlen; j++) {

                if(i==0 || j==0) dp[i][j]=0;

                else if(x.charAt(i-1)==x.charAt(j-1) && i!=j) dp[i][j] =  1 + dp[i-1][j-1];

                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

            }
        }
        
        lcsDp(x, x, xlen, xlen,dp,ans);

        System.out.println(ans);
        
    }



    static void lcsDp(String x,String y,int xLength,int yLength,int[][] dp,StringBuilder ans){


        int i=xLength;
        int j=yLength;
        
        while(i>0 && j>0) {

                

                if(x.charAt(i-1)==y.charAt(j-1) && i!=j ) {
                    ans.append(x.charAt(i-1));
                    i--;
                    j--;
                }

                else{
                    if(dp[i-1][j]>dp[i][j-1]){
                        i--;
                    }else{
                        j--;
                    }
                } 
        }

        ans.reverse();
      
    }

        

    

}