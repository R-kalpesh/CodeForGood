package com.company;

import com.sun.source.tree.BinaryTree;

public class BinarySearchTreeClass {

    private BinaryNode<Integer> root;
//  insert data
    public void insertData(int data){
        root=insertDataHelper(data,root);
    }
    private BinaryNode<Integer> insertDataHelper(int data, BinaryNode<Integer> root) {
        if(root.data==null){
            root.data=data;
            return root;
        }
        if(data>root.data){
            root.rightNode=insertDataHelper(data,root.rightNode);
        }else {
            root.leftNode=insertDataHelper(data,root.leftNode);
        }
        return root;
    }
//  delete data
    public void deleteData(int data){
        root=deleteDataHelper(data,root);
    }
    private BinaryNode<Integer> deleteDataHelper(int data,BinaryNode<Integer> root){
        if(root==null) return null;

        if(data<root.data){
            root.leftNode=deleteDataHelper(data,root.leftNode);
            return root;
        }else if(data>root.data){
            root.rightNode=deleteDataHelper(data,root.rightNode);
            return root;
        }else {  //(root.data==data)
           if(root.leftNode==null && root.rightNode==null){
               return  null;
           }
           else if(root.leftNode==null){
               return root.rightNode;
           }else if(root.rightNode==null){
               return root.leftNode;
           }else{
               BinaryNode<Integer> minNode=root.rightNode;
               while(minNode!=null){
                   minNode=minNode.leftNode;
               }
               root.data=minNode.data;
               root.rightNode=deleteDataHelper(data,root.rightNode);
               return root;
           }
        }
    }
//  print tree
    public void printTree(){
        printTreeHelper(root);
    }
    private void printTreeHelper(BinaryNode<Integer> root){
        if(root==null) return;
        String toBePrinted=root.data+" ";
        if(root.leftNode!=null){
            toBePrinted+="L:"+root.leftNode.data;
        }
        if(root.rightNode!=null){
            toBePrinted+="R:"+root.rightNode.data;
        }
        System.out.println(toBePrinted);
        printTreeHelper(root.leftNode);
        printTreeHelper(root.rightNode);
    }

//  check for data
    public  boolean itHas(int data){
       return itHasHelper(data,root);
    }
    private boolean itHasHelper(int data, BinaryNode<Integer> root) {
        if(root==null) return false;

        if(root.data==data) return  true;
        else if(data<root.data){
//             left side tree search
            return itHasHelper(data,root.leftNode);
        }else {
//            right side tree search
            return itHasHelper(data,root.rightNode);
        }
    }
}
