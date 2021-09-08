package com.company;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 1,1,1,3,2,4,2 };
        PriorityQueue<Pair> q = new PriorityQueue<Pair>(new Pair());
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }


        for(int kk:map.keySet()){
            q.add(new Pair(kk,map.get(kk)));
        }

        ArrayList<Integer> ans=new ArrayList<>();

        while(!q.isEmpty()){
            Pair obj=q.poll();
            for(int i=0;i<obj.value;i++){
                ans.add(obj.key);
            }
        }

        System.out.println(ans);

    }

}

class Pair implements Comparator<Pair> {
    int key;
    int value;

    Pair() {

    }

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int compare(Pair p1, Pair p2) {
        if (p1.value == p2.value)
            return 0;     // no change
        if (p1.value < p2.value)
            return +1;   // no change
        else
            return -1;  // change  the order
    }
}