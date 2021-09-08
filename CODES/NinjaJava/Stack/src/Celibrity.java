import java.util.Scanner;
import java.util.Stack;

public class Celibrity {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[][] mat=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=scn.nextInt();
            }
        }
        System.out.println(findCeli(mat));
    }

    static int findCeli(int[][] mat){
        

        Stack<Integer> s =new Stack<>();


        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    s.push(0);
                }else if(mat[i][j]==1){
                    s.removeAllElements();
                }
            }
            if(s.size()==mat.length){
                int j=i;
                for(int k=0;k<mat[0].length;k++){
                    if(mat[k][j]==1 || mat[j][j]==0){
                        s.push(1);
                    }else if(mat[k][j]==0){
                        s.removeAllElements();
                    }
                }
                if(s.size()==2*mat.length){
                    return j;
                }
            }

        }
        return -1;
    }
}
