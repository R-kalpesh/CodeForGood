package com.company;

public class BinaryNode<T> {

    T data;

    BinaryNode<T> leftNode;
    BinaryNode<T> rightNode;

    public BinaryNode(T data){
        this.data=data;
        this.leftNode=null;
        this.rightNode=null;
    }
    
}
