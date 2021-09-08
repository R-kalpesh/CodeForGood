// import java.io.*;
// import java.util.*;

// public class A_Rank_List {
//     public static void main(String[] args) {
//         try {
//             FastScanner scn = new FastScanner();
//             int n = scn.nextInt(), k = scn.nextInt();
//             Map<Pair, Integer> map = new HashMap<>();

//             for (int i = 0; i < n; i++) {
//                 int a = scn.nextInt(), b = scn.nextInt();
//                 Pair obj=new Pair(a,b);
                
//                 map.put(obj, map.getOrDefault(obj, 0) + 1);
//             }

//             // PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
//             // // Set<Pair> set = new HashSet<>();
//             // for (int i = 0; i < n; i++) {
//             // maxHeap.add(new Pair(scn.nextInt(), scn.nextInt()));
//             // }
//             // // int temp=0;
//             // int count = 1;
//             // ArrayList<Integer> arr = new ArrayList<>();
//             // Pair temp1 = maxHeap.poll();
//             // while (maxHeap.size() > 0) {
//             // Pair temp2 = maxHeap.peek();

//             // if (temp1.a == temp2.a && temp1.b == temp2.b) {
//             // count++;
//             // temp1 = maxHeap.poll();
//             // } else {
//             // int kk = count;
//             // while (kk-- > 0) {
//             // arr.add(count);
//             // }
//             // count = 1;
//             // temp1 = maxHeap.poll();
//             // }

//             // }
//             // int kk = count;
//             // while (kk-- > 0) {
//             // arr.add(count);
//             // }

//             System.out.println(0);
//         } catch (Exception e) {
//             return;
//         }
//     }
// }

// class Pair implements Comparable<Pair> {
//     int a, b;

//     @Override
//     public int compareTo(Pair o) {
//         if ((o.a > a))
//             return ((o.a - a));
//         else if (o.a == a) {

//             if ((o.b >= b))
//                 return ((o.a - a));
//             else
//                 return -1;
//         } else
//             return -1;

//     }

//     // if(a.first>b.first)
//     // return true;

//     // else if(a.first==b.first)
//     // return a.second<b.second;

//     // else
//     // return false;

//     public Pair(int a, int b) {
//         this.a = a;
//         this.b = b;
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