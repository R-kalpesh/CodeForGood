// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Scanner;
// import java.util.StringTokenizer;

// public class A_AquaMoon_and_Two_Arrays {
//     static StringBuilder sb = new StringBuilder();

//     public static void main(String[] args) {

//         fs scn = new fs();
//         int testCase = scn.nextInt();
//         for (int z = 0; z < testCase; z++) {
//             int n = scn.nextInt();
//             int[] arr1 = new int[n];
//             int[] arr2 = new int[n];

//             for (int i = 0; i < n; i++)
//                 arr1[i] = scn.nextInt();

//             for (int i = 0; i < n; i++)
//                 arr2[i] = scn.nextInt();

//             int pl = 0;
//             int mi = 0;

//             for (int i = 0; i < n; i++) {
//                 int a = arr2[i] - arr1[i];
//                 if (a > 0)
//                     pl = pl + a;
//                 else
//                     mi = mi + a;
//             }

//             if (Math.abs(mi) != pl)
//                 System.out.println(-1);

//             else {
//                 ArrayList<Integer> al1 = new ArrayList<>();// plus
//                 ArrayList<Integer> al2 = new ArrayList<>();// minus
//                 for (int i = 0; i < n; i++) {
//                     int a = arr2[i] - arr1[i];
//                     if (a > 0) {
//                         while (a != 0) {
//                             al1.add(i + 1);
//                             a--;
//                         }
//                     } else if (a < 0) {
//                         while (a != 0) {
//                             al2.add(i + 1);
//                             a++;
//                         }
//                     }
//                 }

//                 System.out.println(al1.size());

//                 for (int i = 0; i < al1.size(); i++) {
//                     System.out.println(al2.get(i) + " " + al1.get(i));
//                 }

//             }

//         }

//     }

//     static class fs {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer("");

//         String next() {
//             while (!st.hasMoreTokens())
//                 try {
//                     st = new StringTokenizer(br.readLine());
//                 } catch (IOException e) {
//                     e.printStackTrace();
//                 }
//             return st.nextToken();
//         }

//         int nextInt() {
//             return Integer.parseInt(next());
//         }

//         int[] readArray(int n) {
//             int[] a = new int[n];
//             for (int i = 0; i < n; i++)
//                 a[i] = nextInt();
//             return a;
//         }

//         long nextLong() {
//             return Long.parseLong(next());
//         }
//     }

// }

import java.io.*;
import java.util.*;

public class A_AquaMoon_and_Two_Arrays {
    public static void main(String[] args) {
        try {
            FastScanner scn = new FastScanner();
            int testCase = scn.nextInt();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < testCase; i++) {
                int n = scn.nextInt();
                int[] arr1 = new int[n];
                int[] arr2 = new int[n];

                for (int j = 0; j < n; j++) {
                    arr1[j] = scn.nextInt();

                }
                for (int j = 0; j < n; j++) {
                    arr2[j] = scn.nextInt();

                }
                int plus = 0, minus = 0;
                for (int j = 0; j < n; j++) {
                    int a = arr2[j] - arr1[j];
                    if (a > 0)
                        plus = plus + a;
                    else
                        minus = minus + a;
                }
                if (Math.abs(minus) != plus)
                    ans.append(-1).append('\n');
                else {
                    ArrayList<Integer> add = new ArrayList<>();
                    ArrayList<Integer> sub = new ArrayList<>();

                    for (int j = 0; j < arr2.length; j++) {
                        while (arr1[j] != arr2[j]) {

                            if (arr1[j] > arr2[j]) {
                                sub.add(j + 1);
                                arr1[j]--;

                            } else {
                                add.add(j + 1);
                                arr1[j]++;
                            }

                        }
                    }
                    ans.append(add.size()).append('\n');
                    for (int j = 0; j < add.size(); j++) {
                        ans.append(sub.get(j) + " ").append(add.get(j)).append('\n');
                    }

                }
            }
            System.out.println(ans);
        } catch (

        Exception e) {
            return;
        }
    }
}

class FastScanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(" ");

    String next() {
        while (!st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    int[] readArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}