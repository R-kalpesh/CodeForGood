import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class AdityaStack {
    public static void main(String[] args) {
        
    }

    static class Pair<T,V>{
        T first;
        V second;

        Pair(T first,V second){
            this.first=first;
            this.second=second;
        }

    }

    static Vector<Integer> NearestLargestElementFromRight(int[] arr) {
        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (s.size() == 0) {
                v.add(-1);
            } else if (arr[i] < s.peek()) {
                v.add(s.peek());
            } else if (arr[i] >= s.peek()) {
                while (s.peek() <= arr[i] && s.size() > 0) {
                    s.pop();
                }
                if (s.size() == 0) {
                    v.add(-1);
                } else {
                    v.add(s.peek());
                }
            }
            s.push(arr[i]);
        }
        Collections.reverse(v);
        return v;
        // reverse the vector for answer.
    }

    static Vector<Integer> NearestLargestElementFromLeft(int[] arr) {

        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();
        for (int start = 0; start < arr.length; start++) {
            if (s.size() == 0) {
                v.add(-1);
            } else if (arr[start] < s.peek()) {
                v.add(s.peek());
            } else if (arr[start] >= s.peek()) {

                while (s.size() > 0 && arr[start] >= s.peek()) {
                    s.pop();
                }
                if (s.size() == 0) {
                    v.add(-1);
                } else if (s.peek() > arr[start]) {
                    v.add(s.peek());
                }
            }
            s.push(arr[start]);
        }
        return v;
    }

    static Vector<Integer> NearestSmallerElementFromLeft(int[] arr) {
        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();
        for (int start = 0; start < arr.length; start++) {
            if (s.size() == 0) {
                v.add(-1);
            } else if (arr[start] > s.peek()) {
                v.add(s.peek());
            } else if (arr[start] <= s.peek()) {

                while (s.size() > 0 && arr[start] <= s.peek()) {
                    s.pop();
                }
                if (s.size() == 0) {
                    v.add(-1);
                } else if (s.peek() < arr[start]) {
                    v.add(s.peek());
                }
            }
            s.push(arr[start]);
        }
        return v;
    }

    static Vector<Integer> NearestSmallerElementFromRight(int[] arr) {
        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();
        for (int start = arr.length - 1; start >= 0; start--) {
            if (s.size() == 0) {
                v.add(-1);
            } else if (arr[start] > s.peek()) {
                v.add(s.peek());
            } else if (arr[start] <= s.peek()) {

                while (s.size() > 0 && arr[start] <= s.peek()) {
                    s.pop();
                }
                if (s.size() == 0) {
                    v.add(-1);
                } else if (s.peek() < arr[start]) {
                    v.add(s.peek());
                }
            }
            s.push(arr[start]);
        }
        Collections.reverse(v);
        return v;
        //reverse vector when u print the answer
    }

    static Vector <Integer> spanCalculation(int arr[]) {
        Vector<Integer> v=new Vector<>();
        Stack<Integer> s=new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(s.size() == 0){
                v.add(1);
            }
            if(s.size() > 0 && arr[s.peek()] > arr[i]){
                v.add(i-s.peek());
            }
            if(s.size() > 0 && arr[s.peek()] <= arr[i]){
                while(s.size() > 0 && arr[s.peek()] <= arr[i]){
                    s.pop();
                }
                if(s.size() == 0){
                    v.add(i+1);
                }
                else{
                    v.add(i-s.peek());
                }
            }
            s.push(i);
        }
        return v;
    }

    static Vector<Integer> NslIndex(int[] arr) {
        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();
        for (int start = 0; start < arr.length; start++) {
            if (s.size() == 0) {
                v.add(-1);
            } else if (arr[start] > arr[s.peek()]) {
                v.add(s.peek());
            } else if (arr[start] <= arr[s.peek()]) {

                while (s.size() > 0 && arr[start] <= arr[s.peek()]) {
                    s.pop();
                }
                if (s.size() == 0) {
                    v.add(-1);
                } else if (arr[s.peek()] < arr[start]) {
                    v.add(s.peek());
                }
            }
            s.push(start);
        }
        return v;
    }

    static Vector<Integer> NsrIndex(int[] arr) {
        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();
        for (int start = arr.length - 1; start >= 0; start--) {
            if (s.size() == 0) {
                v.add(arr.length);
//                v.add(-1);
            } else if (arr[start] > arr[s.peek()]) {
                v.add(s.peek());
            } else if (arr[start] <= arr[s.peek()]) {

                while (s.size() > 0 && arr[start] <= arr[s.peek()]) {
                    s.pop();
                }
                if (s.size() == 0) {
                    v.add(arr.length);
//                    v.add(-1);
                } else if (arr[s.peek()] < arr[start]) {
                    v.add(s.peek());
                }
            }
            s.push(start);
        }
        Collections.reverse(v);
        return v;
        //reverse vector when u print the answer
    }

    static int AreaOfHistogram(Vector<Integer> nsl,Vector<Integer> nsr,int[] arr){
        Vector<Integer> ans=new Vector<>();
        for(int i=0;i<arr.length;i++){
            ans.add((nsr.get(i)-nsl.get(i)-1)*arr[i]);
        }
        int max=ans.get(0);
        for(int x:ans){
            if(x>max){
                max=x;
            }
        }
        return max;
    }

    static int AreaOfReactangleOfBinaryMetrix(int[][] matrix){
        int row=matrix.length;
        int column=matrix[0].length;
         Vector<Integer> ans=new Vector<>();
        int[] arr=new int[column];
        for(int j=0;j<row;j++){
            for(int i=0;i<column;i++){
                if(matrix[j][i]!=0){
                    arr[i]=arr[i]+matrix[j][i];
                }else{
                    arr[i]=0;
                }
            }
            Vector<Integer> nsl=NslIndex(arr);
            Vector<Integer> nsr=NsrIndex(arr);
            ans.add(AreaOfHistogram(nsl,nsr,arr));
        }
        int max=ans.get(0);
        for(int x:ans){
            if(x>max){
                max=x;
            }
        }
        return max;
    }

    static int RainWaterProblem(int[] arr){
        Stack<Integer> s= new Stack<>();
        Vector<Integer> LG =new Vector<>();
        Vector<Integer> RG  =new Vector<>();
        Vector<Integer> AreaVector  =new Vector<>();
        int Ans=0;

        for (int i=0;i<arr.length;i++){
            if(s.size()==0){
                LG.add(arr[i]);
                s.push(arr[i]);
            }else if(arr[i]>s.peek()){
                LG.add(arr[i]);
                s.pop();
                s.push(arr[i]);
            }else if(arr[i]<=s.peek()){
                LG.add(s.peek());
            }
        }

        for (int j=arr.length-1;j>=0;j--){
            if(s.size()==0){
                RG.add(arr[j]);
                s.push(arr[j]);
            }else if(arr[j]>s.peek()){
                RG.add(arr[j]);
                s.pop();
                s.push(arr[j]);
            }else if(arr[j]<=s.peek()){
                RG.add(s.peek());
            }
        }

        for (int k=0;k<arr.length;k++){
            AreaVector.add(Integer.min(LG.get(k),RG.get(k))-arr[k]);
        }

        for (int x:AreaVector){
            Ans=Ans+x;
        }

        return Ans;
    }

    static int MinElementInStackWithExtraSpace(int[] arr){
        Stack<Integer> s=new Stack<>();
        Stack<Integer> ss=new Stack<>();

        for(int i=0;i<arr.length;i++){
            if(s.size()==0){
                s.push(arr[i]);
                ss.push(arr[i]);
            }else if(s.peek()<=arr[i]){
                s.push(arr[i]);
            }else if(s.peek()>arr[i]){
                s.push(arr[i]);
                ss.push(arr[i]);
            }
        }
        return ss.peek();
    }

}
