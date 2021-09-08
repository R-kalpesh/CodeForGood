package com.company;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        HashMap<Integer,String> map=new HashMap<>();
//        map.put(0,"Ksl");
//        map.put(0,"KslRam");
//        map.put(1,"Modi");
//        map.put(2,"Khalid");
//        boolean isContain=map.containsKey(1);
//        System.out.println(isContain);
//        System.out.println(map.clone());
//        System.out.println(map.get(2));
//        TreeMap<Integer,String> mapt=new TreeMap<>();
//        mapt.ceilingEntry(2);
//        mapt.put(1,"ram");
//        mapt.put(2,"ramm");
//        mapt.put(1,"venktesh");
//        mapt.put(3,"rammm");
//        System.out.println(mapt.clone());
//        TwoMoreVeriable<Integer> ne=new TwoMoreVeriable<>();
//        PriorityQueue<TwoMoreVeriable<Integer>> list=new PriorityQueue<>();
//        list.add(new TwoMoreVeriable<>(20,20));
//        list.add(new TwoMoreVeriable<>(150,20));
//        list.add(new TwoMoreVeriable<>(30,20));
//
//        System.out.println(list);
////        System.out.println(list.remove());
////        System.out.println(list.remove());
////        System.out.println(list.remove());
////        System.out.println(list.remove());
////        System.out.println(list.remove());
//
//
//        System.out.println(list);

        HashMap<Integer,TwoMoreVeriable<Integer,String>> table=new HashMap<>();
        table.put(0,new TwoMoreVeriable<>(10,"kalpesh0"));
        table.put(1,new TwoMoreVeriable<>(20,"kalpesh1"));
        table.put(2,new TwoMoreVeriable<>(40,"kalpesh2"));
        table.put(3,new TwoMoreVeriable<>(40,"kalpesh3"));
        System.out.println(table.get(0).first+" "+table.get(0).second);
        System.out.println();
    }

}
