package com.company;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

//        int[] arr=new int[]{2,3,1,3,2,4,6,7,9,2,19};
//        int[] arr1=new int[]{2,1,4,3,9,6};
//
//        Solution obj=new Solution();
//        obj.relativeSortArray(arr,arr1);

        String name="kalpesh";
        System.out.println(name.contains("a"));

  
    }

    static  void sumOfDigit(String number,int sum,int i){
        if(i>number.length()-1){
            System.out.println(sum);
            return ;
        }
        sum= sum + (number.charAt(i)-'0'); //Integer.parseInt(String.valueOf(number.charAt(i)))
        sumOfDigit( number,sum,i+1);
        return ;
    }

    static  void checkPalindrome(String name){
        if(name.length()==0 || name.length()==1){
            System.out.println("Yes it's palindrome");
            return ;
        }
        if(name.charAt(0)==name.charAt(name.length()-1)){
              checkPalindrome(name.substring(1,name.length()-1));
        }else {
            System.out.println("No it's not palindrome");
            return ;
        }

    }

    static double geometricSum(int k){
        if(k==0){
            return 1/Math.pow(2,0);
        }

        double sum=geometricSum(k-1);
        return (1/Math.pow(2,k)) +sum ;
    }

    static  void countZero(String ip,int count){
        if(ip.equals("")){
            System.out.println(count);
            return ;
        }

        if(ip.charAt(0)=='0')
            count++;

        countZero(ip.substring(1),count);

    } 

    static int multiplication(int m, int n){
        if(n==0){
          return 0;
        }
        return m+ multiplication(m,n-1);
    }





//    recursion assignment 1

    static  void piChangeTo314(String line, int i){
        if( i==line.length()-1 || i>=line.length() ){
            System.out.println(line);
            return;
        }

        if(line.charAt(i)=='p' && line.charAt(i+1)=='i'){
            String temp=line.substring(0,i);
            line=line.substring(i+2);
            line=temp+"3.14"+line;
            piChangeTo314(line,i+4);
        }else{
            piChangeTo314(line,i+1);
        }
        return;
    }

    static  void removeX(String line,int i){
        if(i>line.length()-1){
            System.out.println(line);
            return;
        }

        if(line.charAt(i)=='x'){
            String temp=line.substring(0,i);
            String  newline=line.substring(i+1);
            line=temp+newline;
            removeX(line,i);
        }else {
            removeX(line,i+1);
        }
        return;
    }

    static void stringToInteger(String line, int i, int ans){
        if(i>line.length()-1){
            System.out.println(ans);
            return;
        }
        ans= (int) ((ans*(i==0?0:Math.pow(10,1))) + (Integer.parseInt(String.valueOf(line.charAt(i)))));
        stringToInteger(line,i+1,ans);
        return;
    }

    static  void seprateSameChar(String line,int i){
        if( i>line.length() ||  i==line.length()-1){
            System.out.println(line);
            return;
        }

        if(line.charAt(i)==line.charAt(i+1)){

            String temp=line.substring(0,i+1);
            line=temp+"*"+line.substring(i+1);
            seprateSameChar(line,i+1);
        }else {
            seprateSameChar(line,i+1);
        }
        return;
    }

    static  void matrixAns(int row,int column,Vector<Integer> vec){
        if(row==1 && column==1){
            vec.add(1);
            return ;
        }
        if (row>1 && column>1) {
            matrixAns(row-1 , column,vec);
            matrixAns(row, column-1,vec) ;
        }
        else if(row==1 && column>1){
            matrixAns(row,column-1,vec);
        }
        else if (row>1 && column==1){
            matrixAns(row-1,column,vec);
        }
    }

//    recursion assignment 2

    static void checkAB(String ip){

        if(ip.equals("") || ip.length()==1 ){
            System.out.println("true");
        }

        if(ip.charAt(0)=='a'){
            if(ip.charAt(1)=='a')  {
                ip=ip.substring(1);
                checkAB(ip);
            }
            else  if(ip.charAt(1)=='b' ){
                if (ip.charAt(2)=='b') {
                    ip = ip.substring(2);
                    checkAB(ip);
                }else {
                    System.out.println("false");
                }
            }
            else
                System.out.println("false");
        }
        else {
            if (ip.charAt(1)=='a'){
                ip=ip.substring(1);
                checkAB(ip);
            }
            else
                System.out.println("false");
        }
    }

    static int stairCase(int n,int ans){
        if(n==0){
            ans++;
            return ans;
        }


        if(n-3>=0){
            ans=stairCase(n-3,ans);
        }
        if(n-2>=0){
            ans=stairCase(n-2,ans);
        }
        if(n-1>=0){
            ans=stairCase(n-1,ans);
        }

        return ans;
    }

    static  int binarySearchWithOutRecursion(int n, int[] arr, int key){

        int s=0;
        int e=arr.length-1;
        int result=-1;

        while (s<=e){
            int mid=s+(e-s)/2;

            if (arr[mid]==key){
                result=mid;
                return result;
            }
            else{
                if (arr[mid]>key){
                    e=mid-1;
                }else
                    s=mid+1;
            }
        }
        return result;
    }

    static int binarySearchWithRecursion(int[] arr, int key, int start, int end){
        if (start>end){
            return -1;
        }
        if (arr[(start+(end-start)/2)]==key) {
            return (start+(end-start)/2);
        }
        else {
            if (arr[(start+(end-start)/2)]>key) {
                return  binarySearchWithRecursion( arr,key,start,(start+(end-start)/2)-1);
            }else {
                return  binarySearchWithRecursion(arr,key, (start+(end-start)/2)+1,end);
            }
        }

    }

    /* in complete*/ static void printSubset(int[] arr,int[] ans){
        if(arr.length==0){
            System.out.println();
        }

        for (int i=0;i<arr.length;i++){
            int choice=arr[i];

            ans[i]=choice;
            printSubset(arr,ans);
        }
    }

    static  void printSubsetOfArray(int[] arr,int i,String op){

        if (i>arr.length-1){
            System.out.println(op);
            return;
        }

        String op1=op;
        String op2=op+arr[i]+" ";
        printSubsetOfArray(arr,i+1,op1);
        printSubsetOfArray(arr,i+1,op2);
    }

    static  void returnSubsetOfArray(int[] arr,List<String > ans,int i,String op){

        if (i>arr.length-1){
            ans.add(op);

            return;
        }

        String op1=op;
        String op2=op+arr[i]+" ";
        returnSubsetOfArray(arr,ans,i+1,op1);
        returnSubsetOfArray(arr,ans,i+1,op2);
        return;
    }

    static void printAllCode(String input,String answer){
        String codes[]
                = {" ","a","b","c","d","e","f","g","h","i","j","k","l","m","n",
                "o","p","q","r","s","t","u","v","w","x","y","z"};

        if(input.length()==0){
            System.out.println(answer);
            return;
        }


        if (input.length()>1) {
            String sum;
            sum =""+ input.charAt(0)  + input.charAt(1) ;
            if(Integer.parseInt((sum))<=26){
                String ans1=answer+codes[Integer.parseInt((sum))];
                printAllCode(input.substring(2),ans1);
            }
        }

        String ans2=answer+codes[input.charAt(0)-'0'];
        printAllCode(input.substring(1),ans2);



    }

    static void printPermutation(String input,String output){
        if(input.length()==0){
            System.out.println(output);
            return;
        }

        for (int i=0;i<input.length();i++) {
            String op2 = output + input.charAt(i);
            printPermutation(input.substring(1),op2);
        }

//        printPermutation(input,op1);
//        printPermutation(input,op2);
        return;
    }

    public static void reverse(Integer[] a,int k){

        Queue<Integer> queue=new ArrayDeque<>();
        queue.addAll(Arrays.asList(a));
        if(k>0){
            for(int i=0;i<a.length-k;i++){
                int temp=queue.poll();
                queue.add(temp);
            }
        }
        if(k<0){
            for(int i=0;i<a.length-k;i++){
                int temp=queue.poll();
                queue.add(temp);
            }
        }
        List<Boolean> arr=new ArrayList<>(5);
        arr.add(1,true);
        for(int i=0;i<a.length;i++){
            a[i]= queue.poll();
        }
    }

    public int diagonalSum(int[][] mat) {

        int i=0,j=0;
        if(mat.length==0){}
        return 1;
    }

}


class KeyPadCode {


    static String codes[]
            = {" ", " ", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String ques = scn.next();
        ArrayList<String> str = new ArrayList<>();
        ArrayList<String> aaa = new ArrayList<>();
        aaa = printKeypad(ques, "", str);
        System.out.println(aaa);
    }

//   '6'  !=  6    ,  '6' -'0' = 6
    static ArrayList<String> printKeypad(String ques, String ans,ArrayList<String> str){

        if (ques.equals("")){
            str.add(ans);
            System.out.print(ans+" ");
            return str;
        }
        char ch=ques.charAt(0);
        String roq=ques.substring(1);
        String codeForCH=codes[ch-'0'];

        for (int i=0;i<codeForCH.length();i++){
            char choice=codeForCH.charAt(i);
            printKeypad(roq,ans+choice,str);
        }
        return str;
    }
}
class SumOfTwoArray{

    public static void main(String[] args) throws Exception {

        Scanner scn=new Scanner(System.in);

        int n1=scn.nextInt();
        int[] arr1=new int[n1];
        for (int i=0;i<n1;i++){
            arr1[i]=scn.nextInt();
        }



        int n2=scn.nextInt();
        int[] arr2=new int[n2];
        for (int i=0;i<n2;i++){
            arr2[i]=scn.nextInt();
        }



        String ans11=new String();
        String ans22=new String();



        for (int i=0;i<arr1.length;i++) {
            ans11=ans11+  arr1[i];
        }


        for (int i=0;i<arr2.length;i++) {
            ans22=ans22+  arr2[i];
        }


        BigInteger num1=new BigInteger(ans11);
        BigInteger num2=new BigInteger(ans22);

        BigInteger sum;
        sum=num1.add(num2);

        String ansSum=sum.toString();
        int[] ans= new int[ansSum.length()];
        for (int i=0;i<ansSum.length();i++){
            ans[i]=ansSum.charAt(i)-'0';
        }

        for (int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }

    }

}
class DifferenceOfTwoArray {

    public static void main(String[] args) throws Exception {

        Scanner scn=new Scanner(System.in);

        int n1=scn.nextInt();
        int[] arr1=new int[n1];
        for (int i=0;i<n1;i++){
            arr1[i]=scn.nextInt();
        }



        int n2=scn.nextInt();
        int[] arr2=new int[n2];
        for (int i=0;i<n2;i++){
            arr2[i]=scn.nextInt();
        }



        String ans11=new String();
        String ans22=new String();



        for (int i=0;i<arr1.length;i++) {
            ans11=ans11+  arr1[i];
        }


        for (int i=0;i<arr2.length;i++) {
            ans22=ans22+  arr2[i];
        }


        BigInteger num1=new BigInteger(ans11);
        BigInteger num2=new BigInteger(ans22);

        BigInteger sum;

        sum=num1.subtract(num2).abs();

        String ansSum=sum.toString();
        int[] ans= new int[ansSum.length()];
        for (int i=0;i<ansSum.length();i++){
            ans[i]=ansSum.charAt(i)-'0';
        }

        for (int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }

    }

}

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] ans=new int[arr1.length];
        int[] ans2=new int[arr1.length];
        int i=0;
        int j=0;
        for(int x:arr2){
            for(int y:arr1){
                if(x==y){
                    ans[i]=x;
                    i++;
                }
            }
        }
        Set<Integer> set = new HashSet<>(arr2.length);
        for(int s : arr1){
            set.add(s);
        }
        for(int s : arr2){
            set.remove(s);
        }




        return ans;
    }
}