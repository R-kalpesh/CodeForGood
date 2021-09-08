package com.company;
import java.util.*;

import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) {

//        Vector<Integer> arr=new Vector<>();
//        arr.addAll(Arrays.asList(new Integer[]{90,80,30,20,50,60,70}));

        Main obj=new Main();
        String op="";
        Vector<String> vec=new Vector<>();
        int n=3;
        obj.generateAllBalencedParentheses(op,n,n,vec);
        System.out.println(vec);
    }

    void generateAllBalencedParentheses(String op,int open,int close,Vector<String> vec){
        if(open==0 && close==0){
            vec.add(op);
            return;
        }
        if(open!=0){
            String op1=op+"(";
            generateAllBalencedParentheses(op1,open-1,close,vec);
        }
        if(close>open){
            String op2=op+")";
            generateAllBalencedParentheses(op2,open,close-1,vec);
        }
        return;
    }

    void latterCasePermutation(String ip, String op,Vector<String> vec){
        if(ip.equals("")){
            vec.add(op);
            return;
        }
        if(Character.isAlphabetic(ip.charAt(0))){
            String op1=op;
            String op2=op;
            op1=op1+ip.toUpperCase().charAt(0);
            op2=op2+ip.toLowerCase().charAt(0);
            ip=ip.substring(1);
            latterCasePermutation(ip,op1,vec);
            latterCasePermutation(ip,op2,vec);
        }else {
            String op1=op+ip.charAt(0);
            ip=ip.substring(1);
            latterCasePermutation(ip,op1,vec);
        }
    }

    void solvePermutationWithSpace(String ip, String op){
        if(ip.length()==0){
            System.out.println(op);
            return;
        }
        String op1=op+ip.charAt(0);
        String op2=op+" "+ip.charAt(0);
        ip=ip.substring(1);
        solvePermutationWithSpace(ip,op1);
        solvePermutationWithSpace(ip,op2);
    }

    void solvePermutationWithCaseChange(String ip, String op){
        if(ip.equals("")){
            System.out.println(op);
            return;
        }
        String op1=op;
        if(97<=ip.charAt(0) && ip.charAt(0)<=122){
              op1=op1+ip.toUpperCase().charAt(0);
        }else {
             op1=op1+ip.toLowerCase().charAt(0);
        };
        String op2=op+ip.charAt(0);
        ip=ip.substring(1);
        solvePermutationWithCaseChange(ip,op1);
        solvePermutationWithCaseChange(ip,op2);
    }

    void solveUniqueSubSets(String ip, String op, Map<String,Integer> map){
         if(ip.length()==0){
             if(map.containsKey("{ "+op+" }")){
                 int value=map.get("{ "+op+" }")+1;
                 map.put("{ "+op+" }",value);
             }else
                 map.put("{ "+op+" }",1);
             return;
        }
        String op1=op;
        String op2=op;
        op2=op2+ip.charAt(0);
        ip=ip.substring(1);
        solveUniqueSubSets(ip,op1,map);
        solveUniqueSubSets(ip,op2,map);
    }

    void towerOfHanoi(int noOfPlates,int source,int destination,int helper){
        if(noOfPlates==1){
            System.out.println("move plate "+noOfPlates+" from "+source+" to "+destination);
            return;
        }
        towerOfHanoi(noOfPlates-1,source,helper,destination);
        System.out.println("move plate "+noOfPlates+" from "+source+" to "+destination);
        towerOfHanoi(noOfPlates-1,helper,destination,source);
    }

    int solveUniqueSubSets(int N, int K){
        if(N==1 && K==1){
            return 0;
        }
        int mid= (int) (Math.pow(2,N-1)/2);
        if (K<=mid){
            return solveUniqueSubSets(N-1,K);
        }else{
            int ans= solveUniqueSubSets(N-1,K-mid);
            return ans==0?1:0;
        }
    }

    void reverse(Stack<Integer> stk ){
        if(stk.size()==1)
            return;
        int temp=stk.pop();
        reverse(stk);
        pushInStack(stk,temp);
    }

    void pushInStack(Stack<Integer> stk, int temp){
        if(stk.size()==0){
            stk.push(temp);
            return;
        }else{
            int value=stk.pop();
            pushInStack(stk,temp);
            stk.push(value);
            return;
        }
    }

    void deletMidelElementInStack(Stack<Integer> stk){
        int pos=stk.size()/2 + 1;
        delete(stk,pos);
    }

    void delete(Stack<Integer> stk,int pos){
        if(pos==1){
            stk.pop();
            return;
        }

        int temp=stk.pop();
        pos--;
        delete(stk,pos);

        stk.add(temp);

    }

    void sortStack(Stack<Integer> stk){
        if (stk.size()==0){
            return;
        }
        int temp=stk.pop();
        sortStack(stk);
        insertInStack(stk,temp);

    }

    void insertInStack(Stack<Integer> stk,int temp){
        if(stk.size()==0 ||stk.peek()<=temp){
            stk.add(temp);
            return;
        }else {
            int value=stk.pop();
            insert(stk,temp);
            stk.add(value);
            return;
        }
    }

    void sort (Vector<Integer> arr){
        if(arr.size()==1)
            return;
        int temp=arr.remove(arr.size()-1);
        sort(arr);
        insert(arr,temp);
    }

    void insert(Vector<Integer> arr, int temp){
        if (arr.size()==0 || arr.elementAt(arr.size()-1)<=temp){
            arr.add(arr.size(),temp);
            return;
        }else {
            int value=arr.remove(arr.size()-1);
            insert(arr,temp);
            arr.add(arr.size(),value);
            return;
        }
    }

}

