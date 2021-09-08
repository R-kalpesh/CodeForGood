

public class PrintScSuperSequnce {

    static StringBuilder ans=new StringBuilder();

    public static void main(String[] args) {
        String a="hello";
        String b="geek";

        int aLen=a.length(),bLen=b.length();

        int[][] dp=new int[aLen+1][bLen+1];

        for(int i=0;i<=aLen;i++){
            for(int j=0;j<=bLen;j++){
                if(i==0 || j==0) dp[i][j]=0;
                else{
                    if(a.charAt(i-1)==b.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }

        lcs(a, b, aLen, bLen, dp);

        System.out.println(ans);
        
   
    }



    public static void lcs(String a,String b,int aLen,int bLen,int[][] dp){

        int i=aLen;
        int j=bLen;
        
        while(i>0 && j>0){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    ans.append(a.charAt(i-1));
                    i--;j--;
                }else{
                    if(dp[i-1][j]>dp[i][j-1]){
                        ans.append(a.charAt(i-1));
                        i--;
                    } 
                    else {
                        ans.append(b.charAt(j-1));
                        j--;
                    }
                }
        }

        while(i>0){
            ans.append(a.charAt(i-1));
            i--;
        }

        while(j>0){
            ans.append(b.charAt(j-1));
            j--;
        }

        ans.reverse();
    }

}
