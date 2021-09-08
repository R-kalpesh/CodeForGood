import java.util.Scanner;

public class GoldMIne {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        
        int row=scn.nextInt();
        int column=scn.nextInt();
        int[][] gold=new int[row][column];
        int[][] dp=new int[row][column];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                gold[i][j]=scn.nextInt();
            }
        }

        helper(gold,dp,row,column);

        int j=0;
        int max=0;
        for(int i=0;i<row;i++){
            max=Math.max(max, dp[i][j]);
        }

        System.out.println(max);

        scn.close();
    }
    static void helper(int[][] gold,int[][] dp,int row,int column){
        
        for(int j=column-1;j>=0;j--){
            for(int i=row-1;i>=0;i--){

                if(j==column-1){
                    dp[i][j]=gold[i][j];
                }
                else if(i==row-1 ){
                    dp[i][j]=Math.max(dp[i-1][j+1], dp[i][j+1])+gold[i][j];
                }
                else if(i==0){
                    dp[i][j]=Math.max(dp[i+1][j+1], dp[i][j+1])+gold[i][j];
                }
                
                else {
                    dp[i][j]=Math.max(dp[i+1][j+1],Math.max(dp[i-1][j+1], dp[i][j+1]))+gold[i][j];
                }

            }
        }
    
    }
}
