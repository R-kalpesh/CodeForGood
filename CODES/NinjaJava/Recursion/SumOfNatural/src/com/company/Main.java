package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ans;
        System.out.println("please give any natural number: ");
        int n=input.nextInt();
        ans=sum(n);
        System.out.println("Sum of "+n+" is : "+ans);
    }

    private static int sum(int n) {
        if(n==1){
            return 1;
        }
        int smallAns=sum(n-1);
        return n+smallAns;
    }
}
