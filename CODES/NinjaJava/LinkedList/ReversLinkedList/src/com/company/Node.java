package com.company;

import java.util.Scanner;

public class Node<T> {
    T data;
    Node<T> next;

    Node(){
        this.next=null;
    }
    public static Node<Integer> add(Node head){

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

    public static void print(Node<Integer> head){

        while (head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println("");
    }

    public static Node<Integer> input(){

        Node<Integer> head=null;
        Node<Integer> tail=null;
        Scanner s =new Scanner(System.in);
        System.out.println("Enter values: ");
        int userData=s.nextInt();
        while(userData!=-1){
            Node<Integer> newNode = new Node<>();
            newNode.data=userData;
            if(head==null){
                head=newNode;
                tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;
            }
            userData =s.nextInt();
        }
        return head;
    }

    public static Node<Integer> insersion(Node<Integer> head, int pos, int data){
        Node<Integer> newNode=new Node<>();
        newNode.data=data;
        if(pos==0){
            newNode.next=head;
            head=newNode;
            return  head;
        }
        int i=0;
        Node<Integer> temp=head;
        while (i<pos-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        return head;
    }

    public static Node<Integer> deleteNode(Node<Integer> head, int pos){
        if(pos==0){
            head=head.next;
            return head;
        }
        int i=0;
        Node<Integer> temp=head;
        while (i<pos-1){
            temp=temp.next;
            i++;
        }
        temp.next=temp.next.next;
        return head;

    }

    public static  Node<Integer> revers(Node<Integer> head){
        if(head.next==null || head==null){
            return head;
        }
        Node<Integer> tail=head.next;
        Node<Integer> finalHead=revers(head.next);
//        Node<Integer> temp=finalHead;
//        while (temp.next!=null){
//            temp=temp.next;
//        }
//        temp.next=head;
//        head.next=null;
        tail.next=head;
        head.next=null;
        return finalHead;
    }
}
