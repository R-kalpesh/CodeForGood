import java.io.*;
import java.util.*;

public class Code {
    public static void main(String[] args) {
        try {
            FastScanner scn = new FastScanner();
            StringBuilder ans = new StringBuilder();
            String s = scn.next();
            boolean found = false;
            int left = 0, right = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == '^') {
                    found = true;
                }

                if (found == false) {
                    if (Character.isDigit(ch)) {
                        left += (int) ch;
                    }

                } else {
                    if (Character.isDigit(ch)) {
                        right += (int) ch;
                    }
                }

            }

            if (right > left) {
                System.out.println("right");
            } else if (left > right) {
                System.out.println("left");
            } else {
                System.out.println("balance");
            }

        } catch (Exception e) {
            return;
        }
    }

    private static boolean nextPermutation(int[] array) {
        boolean hasNext = false;
        int i;
        for (i = array.length - 2; i >= 0; i--) {
            if (array[i] < array[i + 1]) {
                hasNext = true;
                break;
            }
        }
        if (!hasNext) {
            return false;
        }
        int j;
        for (j = i + 1; j < array.length; j++) {
            if (array[j] <= array[i]) {
                break;
            }
        }
        j--;
        swap(array, i, j);
        reverse(array, i + 1, array.length);
        return true;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void reverse(int[] array, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            swap(array, i, j);
        }
    }
}

class Five {
    int a, b, c, d, e;

    public Five(int a, int b, int c, int d, int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
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

// import java.io.*;
// import java.util.*;

// public class Code {
// public static void main(String[] args) {
// try {
// FastScanner scn = new FastScanner();
// StringBuilder ans = new StringBuilder();
// int testCase = scn.nextInt();
// for (int i = 0; i < testCase; i++) {
// int n = scn.nextInt();
// ArrayList<Five> arr = new ArrayList<>();

// for (int j = 0; j < n; j++) {
// Five obj = new Five(scn.nextInt(), scn.nextInt(), scn.nextInt(),
// scn.nextInt(), scn.nextInt());
// arr.add(obj);
// }
// Set<Integer> set = new HashSet<>();
// if (arr.size() == 1) {
// ans.append(1).append('\n');
// } else {
// int del = 0;
// boolean flag = false, deleted = false;
// for (int j = 0; j < n; j++) {
// if (deleted) {
// deleted = false;
// arr.remove(j-1);
// j--;
// }
// int count = 0;
// int val = 0;
// for (int j2 = 0; j2 < n; j2++) {
// if (j != j2) {
// if (arr.get(j).a < arr.get(j2).a)
// count++;
// if (arr.get(j).b < arr.get(j2).b)
// count++;
// if (arr.get(j).c < arr.get(j2).c)
// count++;
// if (arr.get(j).d < arr.get(j2).d)
// count++;
// if (arr.get(j).e < arr.get(j2).e)
// count++;
// }

// if (count >= 3) {
// val++;
// } else if(count!=0) {
// deleted = true;
// del++;
// break;
// }
// count = 0;
// }
// if (val == arr.size() - 1) {
// flag = true;
// ans.append(j + del + 1).append('\n');
// break;
// }

// }
// if (flag == false)
// ans.append(-1).append('\n');
// }
// }
// System.out.println(ans);
// } catch (Exception e) {
// return;
// }
// }

// private static boolean nextPermutation(int[] array) {
// boolean hasNext = false;
// int i;
// for (i = array.length - 2; i >= 0; i--) {
// if (array[i] < array[i + 1]) {
// hasNext = true;
// break;
// }
// }
// if (!hasNext) {
// return false;
// }
// int j;
// for (j = i + 1; j < array.length; j++) {
// if (array[j] <= array[i]) {
// break;
// }
// }
// j--;
// swap(array, i, j);
// reverse(array, i + 1, array.length);
// return true;
// }

// private static void swap(int[] array, int i, int j) {
// int temp = array[i];
// array[i] = array[j];
// array[j] = temp;
// }

// private static void reverse(int[] array, int start, int end) {
// for (int i = start, j = end - 1; i < j; i++, j--) {
// swap(array, i, j);
// }
// }
// }

// class Five {
// int a, b, c, d, e;

// public Five(int a, int b, int c, int d, int e) {
// this.a = a;
// this.b = b;
// this.c = c;
// this.d = d;
// this.e = e;
// }
// }

// class FastScanner {
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(" ");

// String next() {
// while (!st.hasMoreTokens())
// try {
// st = new StringTokenizer(br.readLine());
// } catch (IOException e) {
// e.printStackTrace();
// }
// return st.nextToken();
// }

// int nextInt() {
// return Integer.parseInt(next());
// }

// int[] readArray(int n) {
// int[] a = new int[n];
// for (int i = 0; i < n; i++)
// a[i] = nextInt();
// return a;
// }

// long nextLong() {
// return Long.parseLong(next());
// }
// }