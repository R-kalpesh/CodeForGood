import java.util.Arrays;

public class LcsLengthMemoization {

    static int[][] dp;

    public static void main(String[] args) {

        String x="abcdefm";
        String y="defabcnm";
        
        int xlen=x.length();
        int ylen=y.length();

        dp=new int[xlen+1][ylen+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        lcs(x, y, xlen, ylen,dp);

        System.out.println(dp[xlen][ylen]);

    }

    static int lcs(String x,String y,int xLength,int yLength,int[][] dp){

        if(xLength==0 || yLength==0) return 0;

        if(dp[xLength][yLength]!=-1){
            return dp[xLength][yLength];
        }

        if(x.charAt(xLength-1)==y.charAt(yLength-1)){
            return dp[xLength][yLength]=1+lcs(x, y, xLength-1, yLength-1,dp);
        }else{
            return dp[xLength][yLength]=Math.max(lcs(x, y, xLength, yLength-1,dp), lcs(x, y, xLength-1, yLength,dp));
        }

    }

}

    