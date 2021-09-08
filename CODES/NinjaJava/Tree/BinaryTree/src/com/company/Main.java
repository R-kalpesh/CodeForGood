package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void  print(BinaryNode<Integer> root){
        if(root==null){
            return;
        }
        String toBePrinted=root.data+" ";
        if(root.leftNode!=null){
            toBePrinted +="L:"+root.leftNode.data+",";
        }
        if(root.rightNode!=null){
            toBePrinted +="R:"+root.rightNode.data;
        }
        System.out.println(toBePrinted);
        print(root.leftNode);
        print(root.rightNode);
    }

    public static BinaryNode<Integer> input(Scanner s){
        System.out.println("Plx enter node data");
        int nodedata=s.nextInt();
        if(nodedata==-1){
            return null;
        }
        BinaryNode<Integer> root=new BinaryNode<>(nodedata);
        root.leftNode=input(s);
        root.rightNode=input(s);
        return root;
    }
    //        Scanner s=new Scanner(System.in);
    //        BinaryNode<Integer> root=input(s);
    //        print(root);
    //        s.close();

    public static BinaryNode<Integer> inputLevleWise(){
        Scanner s=new Scanner(System.in);
        Queue<BinaryNode<Integer>> pendingNode=new LinkedList<>();
        System.out.println("enter root data");
        int nodeData=s.nextInt();
        if(nodeData==-1){
            return null;
        }
        BinaryNode<Integer> root=new BinaryNode<>(nodeData);
        pendingNode.add(root);
        while (!pendingNode.isEmpty()){
            BinaryNode<Integer> fornt=pendingNode.poll();
            System.out.println("enter left child of "+fornt.data);
            int leftChild=s.nextInt();
            if (leftChild!=-1){
                BinaryNode<Integer> child=new BinaryNode<>(leftChild);
                pendingNode.add(child);
                fornt.leftNode=child;
            }

            System.out.println("enter right child of "+fornt.data);
            int rightChild=s.nextInt();
            if (rightChild!=-1){
                BinaryNode<Integer> child=new BinaryNode<>(rightChild);
                pendingNode.add(child);
                fornt.rightNode=child;
            }

        }
        return root;
    }
    //        BinaryNode<Integer> root= inputLevleWise();
    //        print(root);

    public static int countNode(BinaryNode<Integer> root){
        if(root==null){
            return 0;
        }
        int count=1;
        count+=countNode(root.leftNode);
        count+=countNode(root.rightNode);
        return count;
    }
    //        BinaryNode<Integer> root= inputLevleWise();
    //        print(root);
    //        System.out.println("No of nodes in tree: "+countNode(root));

    public static void preorder(BinaryNode<Integer> root){
        if(root==null) return;
        System.out.print(" "+root.data+"  ");
        preorder(root.leftNode);
        preorder(root.rightNode);
    }
    
    public static void postorder(BinaryNode<Integer> root){
        if(root==null) return;
        postorder(root.leftNode);
        postorder(root.rightNode);
        System.out.print(" "+root.data+"  ");
    }
    
    public static void inorder(BinaryNode<Integer> root){
        if(root==null) return;

        inorder(root.leftNode);
        System.out.print(" "+root.data+"  ");
        inorder(root.rightNode);
    }
    //        BinaryNode<Integer> root=inputLevleWise();
    //        print(root);
    //        preorder(root);
    //        postorder(root);
    //        inorder(root);

    public static BinaryNode<Integer> buildtree(int in[],int pre[]){
        return buildtreeHelper(in,pre,0,in.length-1,0,pre.length-1);
    }

    private static BinaryNode<Integer> buildtreeHelper(int[] in, int[] pre, int inS, int inE, int preS, int preE) {
        if(inS>inE) return null;
        int rootData=pre[preS];
        BinaryNode<Integer> root=new BinaryNode<>(rootData);

        int rootInIndex=-1;
        for (int i=0;i<=inE;i++){
            if(in[i]==rootData){
                rootInIndex=i;
                break;
            }
        }
        if(rootInIndex==-1){
            return null;
        }

        int leftInS=inS;
        int leftInE=rootInIndex-1;
        int leftPreS=preS+1;
        int leftPreE=leftInE-leftInS+leftPreS;

        int rightInS=rootInIndex+1;
        int rightInE=inE;
        int rightPreE=preE;
        int rightPreS=leftPreE+1;
        root.leftNode=buildtreeHelper(in,pre,leftInS,leftInE,leftPreS,leftPreE);
        root.rightNode=buildtreeHelper(in,pre,rightInS,rightInE,rightPreS,rightPreE);
        return root;

        //        int in[]={4,2,5,1,3,7};
//        int pre[]={1,2,4,5,3,7};
//        BinaryNode<Integer> root=buildtree(in,pre);
//        print(root);
    }


    public static void main(String[] args) {

//        BinaryNode<Integer> root= inputLevleWise();
//        print(root);
//        System.out.println("No of nodes in tree: "+countNode(root));
//        LinkedList<String> names= new LinkedList<>();
//        names.add("kalpesh");
//        names.add("ma");


//        Scanner s=new Scanner(System.in);
//        BinaryNode<Integer> root=input(s);
//        print(root);
//        s.close();

//        BinaryNode<Integer> node1=new BinaryNode<>(2);
//        BinaryNode<Integer> node2=new BinaryNode<>(3);
//        root.rightNode=node1;
//        root.leftNode=node2;

//        BinaryNode<Integer> root=inputLevleWise();
//        print(root);
//        preorder(root);
//        postorder(root);
//        inorder(root);


//        int in[]={4,2,5,1,3,7};
//        int pre[]={1,2,4,5,3,7};
//        BinaryNode<Integer> root=buildtree(in,pre);
//        print(root);
    }
}
 