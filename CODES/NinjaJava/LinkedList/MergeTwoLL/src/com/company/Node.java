package com.company;

import java.util.Scanner;

public class Node {
    int data;
    Node next;
    public Node(){

        this.next=null;
    }

    public static Node add(Node head){

        Node temp=head;
        Node tail=head;
        System.out.println("Plz enter values");
        Scanner s=new Scanner(System.in);
        int udata=s.nextInt();
        while (udata!=-1){
            Node newNode=new Node();
            newNode.data=udata;
            if(head==null){
                head=newNode;
                tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;
            }
            udata=s.nextInt();
        }
        return head;
    }

    public static void print(Node head){
        if(head==null){
            return;
        }
        while (head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println("");
    }

}
