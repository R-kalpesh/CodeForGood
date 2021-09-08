package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution obj=new Solution();
        int[] arr=new int[]{6,5,3,2,8,10,9};

        System.out.println( obj.findKthLargest(arr,3));


    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    static class Solution {
        public ArrayList<Integer> findKthLargest(int[] arr, int k) {

            PriorityQueue<Integer> minHeap=new PriorityQueue<>();
            ArrayList<Integer> ans=new ArrayList<>();

            for(int x:arr){
                minHeap.add(x);
                if(minHeap.size()>k) ans.add(minHeap.poll());
            }

            while(minHeap.size()>0){
                ans.add(minHeap.poll());
            }

            return  ans;
        }
    }

    private static boolean flag=false;

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node (int data){
            this.data=data;
        }
        Node(){}
    }

    public static Node construct(int[] arr){
        Node root=null;
        Stack<Node> s=new Stack<>();
        for(int x: arr){
            if(x==-1){
                s.pop();
            }
            else{
                Node t=new Node();
                t.data=x;
                if (s.size()>0){
                    s.peek().children.add(t);
                }else{
                    root=t;
                }
                s.push(t);
            }
        }
        return root;
    }

    public static void display(Node node){
        String str=node.data + "->";
        for (Node child:node.children){
            str+=(child.data+", ");
        }
        str+=".";
        System.out.println(str);

        for(Node child:node.children){
            display(child);
        }
    }

    public static Node linearize(Node node){

        if(node.children.size()==0){
            return node;
        }

        Node stk=linearize(node.children.get(node.children.size()-1));


        while(node.children.size()>1){
            Node last=node.children.remove(node.children.size()-1);
            Node secLast=node.children.get(node.children.size()-1);
            Node secLastTail=linearize(secLast);
            secLastTail.children.add(last);
        }

        return stk;

    }

    public static boolean find(Node node, int data) {

        if(node.data==data){
            flag=true;
            return flag;
        }

        for(Node child:node.children){
            find(child,data);
        }

        return flag;
    }
}

