package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> q1=new ArrayDeque<>();
        q1.add(10);
        q1.add(20);
        q1.add(30);
        q1.add(40);
        for (int ele:q1){
            System.out.println(ele);
        }

//        System.out.println(q1.remove());
    }
}
