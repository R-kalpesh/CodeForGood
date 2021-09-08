package com.company;

public class Main {

    public static void main(String[] args) {
//            int str[]=new int[10];
        int str[] =new int[]{1, 2, 3, 7, 84, 5, 6, 1, 5, 3};
        mergeSort(str,0,(str.length-1));
        for (int i=0;i<str.length;i++){
            System.out.print(str[i]+" ");
        }
    }

    public static void mergeSort(int input[],int si,int ei){

        if(si>=ei){
            return;
        }

        int mid=(si+ei)/2;

        mergeSort(input,si,mid);
        mergeSort(input,mid+1,ei);

        merge(input,si,ei);
    }

    private static void merge(int[] input, int si, int ei) {
        int mid=(si+ei)/2;

        int ans[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;

        while (i<=mid && j<=ei){
            if(input[i]<=input[j]){
                ans[k]=input[i];
                i++;
                k++;
            }else {
                ans[k]=input[j];
                j++;
                k++;
            }
        }

        while (i<=mid){
            ans[k]=input[i];
            i++;
            k++;
        }
        while (j<=ei){
            ans[k]=input[j];
            j++;
            k++;
        }

        for (int index=0;index<ans.length;index++){
            input[si+index]=ans[index];
        }
    }
}
