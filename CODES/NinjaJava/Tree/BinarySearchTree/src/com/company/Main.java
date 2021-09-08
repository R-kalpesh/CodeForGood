package com.company;

import com.sun.source.tree.BinaryTree;

import java.util.LinkedList;

public class Main {


//    checking for given tree is BST or not
    public static pair<Boolean,pair<Integer,Integer>> isBst(BinaryNode<Integer> root){
        if (root==null){
            pair<Boolean,pair<Integer,Integer>> output=new pair<Boolean,pair<Integer,Integer>>();
            output.first=true;
            output.second=new pair<Integer,Integer>();
            output.second.first=Integer.MAX_VALUE;
            output.second.second=Integer.MIN_VALUE;
            return output;
        }

        pair<Boolean,pair<Integer,Integer>> leftOutput=isBst(root.leftNode);
        pair<Boolean,pair<Integer,Integer>> rightOutput=isBst(root.rightNode);

        int min=Math.min(root.data,Math.min(leftOutput.second.first,rightOutput.second.first));
        int max=Math.max(root.data,Math.max(leftOutput.second.second,rightOutput.second.second));
        boolean isBst=(root.data>leftOutput.second.second)&&(root.data<=rightOutput.second.first)
                && leftOutput.first && rightOutput.first ;

        pair<Boolean,pair<Integer,Integer>> output=new pair<Boolean,pair<Integer,Integer>>();
        output.first=isBst;
        output.second=new pair<Integer,Integer>();
        output.second.first=min;
        output.second.second=max;
        return output;
    }
    public static boolean isBst2(BinaryNode<Integer> root,int min,int max){
        if (root==null){
            return true;
        }
        if(min>root.data||root.data>max){
            return false;
        }
        boolean isRightOk=isBst2(root,min,root.data-1);
        boolean isIeftOk=isBst2(root,root.data,max);
        return isIeftOk && isRightOk;
    }
//  fuction which give path of give node from root
    public static LinkedList<Integer> getPath(BinaryNode<Integer> root,int data) {
        if(root.data==null){
            return null;
        }
        if(root.data==data){
            LinkedList<Integer> output=new LinkedList<>();
            output.add(root.data);
            return output;
        }

        LinkedList<Integer> leftOutput=getPath(root.leftNode,data);
        if (leftOutput!=null){
            leftOutput.add(root.data);
            return leftOutput;
        }
        LinkedList<Integer> rightOutput=getPath(root.rightNode,data);
        if (rightOutput!=null){
            rightOutput.add(root.data);
            return rightOutput;
        }else {
            return null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeClass b=new BinarySearchTreeClass();
        b.insertData(50);
        b.insertData(20);
        b.insertData(30);
        b.insertData(40);
        b.insertData(45);
        b.insertData(55);
        b.insertData(35);
        b.printTree();
        

    }
}
