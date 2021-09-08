package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Plz enter value of n : ");
        int n=input.nextInt();
        int ans=fact(n);
        System.out.println("Answer : " + ans);

    }

    public static int fact(int n){
        if(n==0){
            return 1;
        }
        int smallAns=fact(n-1);
        return n*smallAns;
    }
}
