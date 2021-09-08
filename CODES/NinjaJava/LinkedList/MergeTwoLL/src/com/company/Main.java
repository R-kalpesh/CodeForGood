package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Node LL1=new Node();
        Node LL2=new Node();
        Node LL3=new Node();
        Node head1=null;
        Node head2=null;

        head1=LL1.add(head1);
        head2=LL2.add(head2);

        LL1.print(head1);
        LL2.print(head2);

        Node head3=null;
        Node tail3=null;
        Node temp2=head2;
        Node temp1=head1;
        if ((temp1.next!=null) && (temp2.next != null)){
            if (LL1.data<=LL2.data){
                head3=LL1;
                tail3.next=temp1;
                temp1=temp1.next;
            }else {
                head3=LL2;
                tail3.next=temp2;
                temp2=temp2.next;
            }
            tail3=tail3.next;
        }
        LL3.print(head3);
    }
}
