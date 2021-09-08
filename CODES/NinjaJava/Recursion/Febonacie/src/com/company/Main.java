package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter value of n: "); 
        int n=input.nextInt();
        System.out.println(feb(n));
    }

    public static int feb(int n){

        if(n==0||n==1){
            return n;
        }
        return feb(n-1)+feb(n-2);
    }
}
