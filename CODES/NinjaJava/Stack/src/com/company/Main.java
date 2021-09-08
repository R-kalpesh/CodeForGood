package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
//        Stack<Integer> st1=new Stack<>();
//        st1.add(10);
//        st1.add(20);
//        st1.add(30);
//        System.out.println(st1.size());
//        System.out.println(st1.clone());

        StackUsingArray st1=new StackUsingArray();
        st1.push(10);
        st1.push(20);
        st1.push(30);
        st1.push(40);
//        System.out.println(st1.top());
//        System.out.println(st1.size());
//        st1.pop();
//        System.out.println(st1.top());
//        System.out.println(st1.size());
        while (!st1.isEmpty()){
            try {
                System.out.print(st1.pop()+" ");
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
