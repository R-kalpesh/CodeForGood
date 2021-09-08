package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Node<Integer> ll1=new Node<>();
        Node head=null;
        head=ll1.add(head);
        Node.print(head);
        head=Node.revers(head);
        Node.print(head);

//        LinkedList<Student> list =new LinkedList<>();
////        stud.name="kal";
////        stud.usn="1js";
//        list.add(0,new Student(10,"kalpesh","1js18cs125"));
//        list.addFirst(new Student(20,"Khalid ","1js18cs115"));
//        list.add(new Student(30,"KhalidMc ","1js18cs11555"));
//        list.addFirst(new Student(0,"KhalidMc ","1"));
//
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i).name.toUpperCase()+" "+list.get(i).usn+" "+list.get(i).rollNumber);
//        }

//        ArrayList<Student> list=new ArrayList<>();
//        list.add(new Student(10,"kalpesh","1js18cs125"));
//        list.add(new Student(20,"kalpesh","1js18cs125"));
//        list.add(new Student(30,"kalpesh","1js18cs125"));
//        list.add(0,new Student(0,"kalpesh","1js18cs125"));
//
//        for (int i=0;i<list.size();i++){
//              System.out.println(list.get(i).name.toUpperCase()+" "+list.get(i).usn+" "+list.get(i).rollNumber);
//          }

    }
}