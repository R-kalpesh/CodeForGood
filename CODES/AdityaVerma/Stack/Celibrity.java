import java.util.Arrays;
import java.util.Stack;

public class Celibrity {
    public static void main(String[] args) {
    
        int[][] arr=new int[][]{
                {1,8},
                {5,12},
                {14,19},{21 ,28},{25, 27},{17 ,22}};
       mergeOverlappingIntervals(arr);

    }

    public static void mergeOverlappingIntervals(int[][] arr) {

        Pair[] pairs=new Pair[arr.length];

        for(int i=0;i< arr.length;i++){
            pairs[i]=new Pair(arr[i][0],arr[i][1]);
        }
        Arrays.sort(pairs);

        Stack<Pair> s=new Stack<>();

        for(int i=0;i< arr.length;i++){
            if(i==0){
                s.add(pairs[i]);
            }else{
                Pair top=s.peek();
                Pair arrtop=pairs[i];
                if(top.et>arrtop.st){

                    s.peek().et=Math.max(top.et,arrtop.et);

                }else{
                    s.push(arrtop);
                }
            }
        }


        Stack<Pair> ans=new Stack<>();

        while (s.size()>0){
            ans.push(s.pop());
        }

        while ((ans.size()>0)){
            Pair p=ans.pop();
            System.out.println(p.st+" "+p.et);
        }

    }
    
    public static class Pair implements Comparable<Pair>{
        int st,et;

        public Pair(int st,int et){
            this.st=st;
            this.et=et;
        }

        public int compareTo(Pair other){
            if(this.st!=other.st)
                return this.st-other.st;
            else
                return this.et-other.et;
        }
    }
}