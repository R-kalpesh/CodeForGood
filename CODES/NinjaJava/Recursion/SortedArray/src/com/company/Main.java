package com.company;

public class Main {

    public static void main(String[] args) {
	        int arry[]={1,2,3,1};
        System.out.println(isSorted3(arry));
    }

    public static boolean isSorted1(int arry[]){

        if(arry.length <= 1){
            return true;
        }
        int smallerArray[]=new int[arry.length-1];
        for (int i=0;i<arry.length-1;i++){
            smallerArray[i]=arry[i+1];
        }

        boolean smallAns=isSorted1(smallerArray);
        if(!smallAns){
            return false;
        }
        if(arry[0]<=arry[1]){
            return true;
        }
        else {
            return false;
        }
    }


    public static boolean isSorted2(int arry[]){
        if(arry.length <= 1){
            return true;
        }
        if(arry[0]>arry[1]){
            return false;
        }
        int smallerArray[]=new int[arry.length-1];
        for (int i=0;i<arry.length-1;i++){
            smallerArray[i]=arry[i+1];
        }

        boolean smallAns=isSorted2(smallerArray);
        return smallAns;
    }

    public static  boolean isSorted3(int arry[]){
        return isSorted3(arry,0);
    }
//    becoz user don't kown what is index? it is for our benifits.

    private static boolean isSorted3(int arry[],int index){
        if(index >=arry.length-1)return true;
        if(arry[index]>arry[index+1])return false;
        boolean smallAns=isSorted3(arry,index+1);return smallAns;
    }


}
