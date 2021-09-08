package com.company;

public class StackUsingArray {

    private int data[];
    private int top;//index of top most element

    public StackUsingArray(){
        data =new int[3];
        top=-1;
    }



    public int size(){
        return top+1;
    }

    public int top() throws EmptyStackEception{
        if(size()==0){
            EmptyStackEception e=new EmptyStackEception();
            throw e;
        }
        return data[top];
    }

    public  boolean isEmpty(){
        return top==-1;
    }

    public void push(int item) {
        if(size()==data.length){
           doubleCapacity();
        }
        top++;
        data[top]=item;
    }

    private void doubleCapacity(){
        int temp[]=data;
        data=new int[2*data.length];
        for(int i=0;i<temp.length;i++){
            data[i]=temp[i];
        }
    }

    public int pop() throws  Exception{
        if(size()==0){
            Exception e =new Exception();
            throw e;
        }
        int item=data[top];
        top--;
        return item;
    }
}
