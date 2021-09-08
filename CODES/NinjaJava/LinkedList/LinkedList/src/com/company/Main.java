package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Node<Integer> head=Node.input();
//        head=Node.insersion(head,2,80);
        Node.print(head);
        head=Node.deleteNode(head,2);
        Node.print(head);

    }


}
