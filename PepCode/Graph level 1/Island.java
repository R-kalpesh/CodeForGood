import java.io.*;
import java.util.*;

public class Island {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // write your code here
      boolean[][] vis = new boolean[m][n];
      int ans = 0;
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if (arr[i][j] == 0 && vis[i][j] == false) {
               fun(arr, vis, i, j, m, n);
               ans++;
            }
         }
      }

      System.out.println(ans);
   }

   static void fun(int[][] arr, boolean[][] vis, int i, int j, int m, int n) {

      if (((i < 0 || i >= m) || (j < 0 || j >= n)) || vis[i][j] == true || arr[i][j] == 1) {
         return;
      }

      vis[i][j] = true;

      fun(arr, vis, i + 1, j, m, n);
      fun(arr, vis, i - 1, j, m, n);
      fun(arr, vis, i, j + 1, m, n);
      fun(arr, vis, i, j - 1, m, n);

   }

}