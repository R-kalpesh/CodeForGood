package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        TreeNode<Integer> root=new TreeNode<>(10);
//        TreeNode<Integer> node1=new TreeNode<>(20);
//        TreeNode<Integer> node2=new TreeNode<>(30);
//        TreeNode<Integer> node3=new TreeNode<>(40);
//        TreeNode<Integer> node4=new TreeNode<>(50);
//        root.children.add(node1);
//        root.children.add(node2);
//        root.children.add(node3);
//        node2.children.add(node4);
//        System.out.println(root.children.clone());
        TreeMap <Integer,String> tree=new TreeMap<>();
        tree.ceilingEntry(10);
        tree.ceilingEntry(10);
        tree.ceilingEntry(10);
        System.out.println(tree.clone());
       
    }
}
