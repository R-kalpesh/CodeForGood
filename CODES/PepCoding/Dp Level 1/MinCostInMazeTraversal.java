import java.util.Scanner;

public class MinCostInMazeTraversal {
    
    public static void main(String[] args) {
        
        Scanner scn=new Scanner(System.in);
        
        int Row=scn.nextInt();
        int Column=scn.nextInt();
        int[][] maze=new int[Row][Column];
        int[][] dp=new int[Row][Column];
        
        for(int i=0;i<Row;i++){
            for(int j=0;j<Column;j++){
                maze[i][j]=scn.nextInt();
            }
        }

        helper(maze,dp,Row,Column);

        System.out.println(dp[0][0]);

        scn.close();

    }

    static void helper(int[][] maze,int[][] dp,int row,int column){

        for(int i=row-1;i>=0;i--){
            for(int j=column-1;j>=0;j--){

                if(i==row-1 && j==column-1){
                    dp[row-1][column-1]=maze[row-1][column-1];
                }
                else if(i==row-1 ){
                    dp[i][j]=dp[i][j+1]+maze[i][j];
                }
                else if(j==column-1 ){
                    dp[i][j]=dp[i+1][j]+maze[i][j];
                }
                else {
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+maze[i][j];
                }

            }
        }
    
    }
}


















