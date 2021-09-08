import java.io.*;
import java.util.*;

public class Code {
    public static void main(String[] args) {
        try {
            FastScanner scn = new FastScanner();
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scn.nextInt();
            }
            int len = 2, max = 2;

            for (int i = 2; i < arr.length; i++) {
                if (arr[i] == arr[i - 1] + arr[i - 2]) {
                    len++;
                    max = Math.max(max, len);
                } else {
                    len = 2;
                }
            }
            if (n == 1)
                System.out.println(1);
            else
                System.out.println(max);

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