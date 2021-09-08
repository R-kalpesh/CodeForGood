// import java.io.*;
// import java.util.*;

// public class Code1 {
//     public static void main(String[] args) {
//         try {
//             FastScanner scn = new FastScanner();
//             int testCase = scn.nextInt();
//             StringBuilder ans = new StringBuilder();
//             for (int i = 0; i < testCase; i++) {
//                 int h = scn.nextInt(), w = scn.nextInt();
//                 int[][] mat = new int[h][w];
//                 mat[0][0] = 1;
//                 for (int j = 0; j < h; j++) {

//                     for (int j2 = 0; j2 < w; j2++) {
//                         // (i−1,j), (i,j−1), (i+1,j), (i,j+1), (i−1,j−1), (i−1,j+1), (i+1,j−1),
//                         // (i+1,j+1)

//                         if ((j == 0 || j == h - 1) || (j2 == 0 || j2 == w - 1)) {

//                             if (j - 1 >= 0 && j2 - 1 >= 0) {
//                                 if (j2 == 1 && mat[j - 1][j2 - 1] == 1) {
//                                     mat[j][j2] = 0;
//                                     continue;
//                                 } else if (j2 == 1 && mat[j - 1][j2 - 1] == 0) {
//                                     if (mat[j - 1][j2] == 0) {
//                                         mat[j][j2] = 1;
//                                         continue;
//                                     }

//                                 }
//                             }
//                             if (j - 1 >= 0 && j2 - 1 >= 0) {
//                                 if (j == h - 1 && j2 == 1 && mat[j - 1][j2 - 1] == 1) {
//                                     mat[j][j2] = 0;
//                                     continue;
//                                 } else if (j == h - 1 && j2 == 1 && mat[j - 1][j2 - 1] == 0) {
//                                     if (mat[j - 1][j2] == 0) {
//                                         mat[j][j2] = 1;
//                                         continue;
//                                     }
//                                 }
//                             }

//                             if (j == h - 1 && j2 == w - 2 && mat[j - 1][j2 + 1] == 1) {
//                                 mat[j][j2] = 0;
//                                 continue;
//                             } else if (j == h - 1 && j2 == w - 2 && mat[j - 1][j2 + 1] == 0) {
//                                 if (mat[j-1][j2] == 0) {
//                                     mat[j][j2] = 1;
//                                     continue;
//                                 }
//                             }

//                             if (((j == 0 || j == h - 1) && j2 - 1 >= 0)) {
//                                 if (mat[j][j2 - 1] == 0) {
//                                     mat[j][j2] = 1;
//                                 }
//                                 if (mat[j][j2 - 1] == 1) {
//                                     mat[j][j2] = 0;
//                                 }
//                             }

//                             if ((j2 == 0 || j2 == w - 1) && j - 1 >= 0) {
//                                 if (mat[j - 1][j2] == 0) {
//                                     mat[j][j2] = 1;
//                                 }
//                                 if (mat[j - 1][j2] == 1) {
//                                     mat[j][j2] = 0;
//                                 }
//                             }

//                         }

//                     }
//                 }
//                 for (int k = 0; k < mat.length; k++) {
//                     for (int k2 = 0; k2 < mat.length; k2++) {
//                         System.out.print(mat[k][k2]);
//                     }
//                     System.out.println("");
//                 }
//                 System.out.println("");
//             }
//             System.out.println(ans);
//         } catch (Exception e) {
//             return;
//         }
//     }
// }

// class FastScanner {
//     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     StringTokenizer st = new StringTokenizer(" ");

//     String next() {
//         while (!st.hasMoreTokens())
//             try {
//                 st = new StringTokenizer(br.readLine());
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         return st.nextToken();
//     }

//     int nextInt() {
//         return Integer.parseInt(next());
//     }

//     int[] readArray(int n) {
//         int[] a = new int[n];
//         for (int i = 0; i < n; i++)
//             a[i] = nextInt();
//         return a;
//     }

//     long nextLong() {
//         return Long.parseLong(next());
//     }
// }