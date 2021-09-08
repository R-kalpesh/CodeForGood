// import java.io.*;
// import java.util.*;

// public class B_AquaMoon_and_Stolen_String {
//     public static void main(String[] args) {
//         try {
//             ff scn = new ff();
//             int testCase = scn.nextInt();
//             StringBuilder ans=new StringBuilder();
//             for (int i = 0; i < testCase; i++) {
//                 int n = scn.nextInt(), m = scn.nextInt();
//                 int[] chars = new int[26];
//                 ArrayList<String> strs = new ArrayList<>();
//                 for (int j = 0; j < n; j++) {
//                     String s = scn.next();
//                     strs.add(s);
//                     for (int k = 0; k < m; k++) {
//                         char ch = s.charAt(k);
//                         chars[(int) ch - 97]++;
//                     }
//                 }

//                 for (int j = 0; j < n - 1; j++) {
//                     String s = scn.next();

//                     for (int k = 0; k < m; k++) {
//                         char ch = s.charAt(k);
//                         chars[(int) ch - 97]--;
//                     }
//                 }

                
                
//                 for (String x : strs) {
//                     Boolean isBreak = false;
//                     ArrayList<Character> line = new ArrayList<>();

//                     for (int j = 0; j < m; j++) {
//                         line.add(x.charAt(j));
//                     }

//                     for (int j = 0; j < chars.length; j++) {
//                         if (chars[j] != 0) {
//                             char ch=(char)(j+97);
//                             if (line.contains(ch)) {

//                             } else {
//                                 isBreak = true;
//                                 break;
//                             }
//                         }
//                     }
//                     if (isBreak == false) {
//                         ans.append(x).append('\n');
//                         break;
//                     }

//                 }

//             }
//             System.out.println(ans);
//         } catch (Exception e) {
//             return;
//         }
//     }
// }

// class ff {
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