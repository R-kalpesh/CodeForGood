import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(findMinFibonacciNumbers(19));
    }

    public static int findMinFibonacciNumbers(int k) {

        Stack<Integer> stc = new Stack<>();
        int a = 0, b = 1;
        stc.add(a);
        stc.add(b);

        while (stc.peek() <= k) {
            stc.add(stc.peek() + stc.get(stc.size() - 2));
        }
        int count = 0;
        if (stc.peek() == k)
            return 1;
        else {
            stc.pop();
            int sum = 0;
            while (sum != k) {
                if (sum + stc.peek() <= k) {
                    sum += stc.peek();
                    count++;
                }
                stc.pop();
            }
        }

        return count;
    }
}