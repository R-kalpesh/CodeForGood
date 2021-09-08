package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("kalpesh");
        nameList.add("Khalid");
        nameList.add("modi");
        nameList.add("rahul gandhi");
        System.out.println("Size: "+nameList.size());
        System.out.println("Elements: "+nameList.clone());
//        for(String element:nameList){
//            System.out.print(element+",");
//        }
        System.out.println(" ");
        nameList.set(0,"Swami");
        nameList.add(0,"Amitbhai Shah");
        System.out.println("Elements: "+nameList.clone());
    }
}
