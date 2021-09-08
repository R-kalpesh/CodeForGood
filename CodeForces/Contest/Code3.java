import java.io.*;
import java.util.*;

public class Code3 {
    public static void main(String[] args) {
        try {
            ffff scn = new ffff();
            int y = scn.nextInt(), k = scn.nextInt(), n = scn.nextInt();

            PriorityQueue<Integer> ans = new PriorityQueue<>();
            int temp = 0;
            for (int i = n - y; i >= 1; i--) {
                long gg = (i + y) % (long) k;
                if (gg == 0)
                    ans.add(i);
                if (ans.size() == 1) {
                    temp = i;
                    break;
                }
            }
            if (ans.size() == 0) {
                System.out.println(-1);
            } else {
                ans.clear();
                for (int i = temp; i >= 1; i -= k) {

                    long gg = (i + y) % (long) k;
                    if (gg == 0)
                        ans.add(i);
                    if (ans.size() == 1)
                        temp = i;
                }
                StringBuilder sb = new StringBuilder();
                while (ans.size() > 0)
                    sb.append(ans.poll() + " ");

                System.out.println(sb);
            }

        } catch (Exception e) {
            return;
        }
    }
}

class ffff {
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