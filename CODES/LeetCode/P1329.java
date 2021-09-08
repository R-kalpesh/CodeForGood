import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1329 {
    public static void main(String[] args) {
        
        Scanner scn=new Scanner(System.in);
        int row=scn.nextInt(),column=scn.nextInt();
        int[][] mat=new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                mat[i][j]=scn.nextInt();
            }
        }

        HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                int diff=i-j;

                if(!map.containsKey(diff)){
                    map.put(diff, new PriorityQueue<>());
                }
                map.get(diff).add(mat[i][j]);
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                int diff=i-j;
                mat[i][j]=map.get(diff).poll();
            }
        }


    }
}
