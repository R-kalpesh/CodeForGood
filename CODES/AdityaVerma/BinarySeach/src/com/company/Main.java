package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int arr[]={1,2,8,4,9};
        int noOfStudent=3;
        AllocateMinimumNumberOfPages flipkart=new AllocateMinimumNumberOfPages();
        int totalPages= Arrays.stream(arr).sum();
        int output=flipkart.minimiseNoOfPages(arr,noOfStudent);
        int result=Math.max((totalPages-output),output);
        System.out.println(output);
    }
}

class AllocateMinimumNumberOfPages {

    public int minimiseNoOfPages(int[] arr,int noOfStudent){
        int start= Arrays.stream(arr).max().getAsInt();
        int end= Arrays.stream(arr).sum();
        int noOfBooks=arr.length;
        int result = -1;

        if(noOfStudent>noOfBooks){
            return -1;
        }else{
            while(start<=end){

                int mid=start+(end-start)/2;

                if(isValid(arr,mid,noOfStudent)){
                    result=mid;
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            return result;
        }

    }
    boolean isValid(int arr[],int maxNoOfPages,int noOfStudent){

        int student=1;
        int sumOfPagesPerStudent=0;
        int noOfBooks=arr.length;

        for (int i=0;i<noOfBooks;i++){

            sumOfPagesPerStudent=sumOfPagesPerStudent+arr[i];

            if(sumOfPagesPerStudent>maxNoOfPages){
                student++;
                sumOfPagesPerStudent=arr[i];
            }

            if (student>noOfStudent){
                return false;
            }
        }
        return true;
    }
}


class TwoDArray {
    int result[]={-1,-1};
    int i=0,j=0;
    public int[] search(int array[][],int key,int row,int column){
        i=0;
        j=column-1;
        while (i>=0 && i<row && j>=0 && j<column){
            if(array[i][j]==key){
                result[0]=i;
                result[1]=j;
                return result;
            }
            else if(key>array[i][j])
                i++;
            else
                j--;
        }
        return result;
    }
}

// peek also same
class BiotonicPeek{

    public int start,end;

    public int getMaximum(int arr[]){
        start=0;
        end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(mid!=0 && mid!=arr.length-1){
                if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                    return  mid;
                }else{
                    if (arr[mid]<arr[mid-1]){
                        end=mid-1;
                    }else if(arr[mid]<arr[mid+1]){
                        start=mid+1;
                    }
                }
            }else{
                if(mid==0){
                    if (arr[0]>arr[1]){
                        return  0;
                    }else
                        return 1;
                }else if(mid==arr.length-1){
                    if(arr[mid]>arr[mid-1]){
                        return mid;
                    }else
                        return mid-1;
                }
            }
        }
        return -1;
    }


}

class BiotonicElementSeaarch{
//        int arr[]={10,20,25,30,35,33,27,22,17,16};
//        int key=17;
//        BiotonicPeek obj=new BiotonicPeek();
//        int output=obj.getMaximum(arr);
//        BinarySearch binarySearch=new BinarySearch();
//        DescendingBinarySearch descendingBinarySearch = new DescendingBinarySearch();
//        int firstArray=binarySearch.fun(arr,key,0,output-1);
//        int secondArray=descendingBinarySearch.se(arr,key,output,arr.length-1);
//        if(firstArray!=-1){
//            System.out.println("Key element is present at "+firstArray);
//        }else if(secondArray!=-1){
//            System.out.println("Key element is present at "+secondArray);
//        }else{
//            System.out.println("key element is not present in array");
//        }
}

class BinaryInfinetArray{
    public int fun(int arry[],int key,int start,int end) {
        int result=-1;
        while ( key>arry[end]) {
            if (arry[end] < key) {
                start = end;
                end = end * 2;
            }
        }
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if (arry[mid] == key) {
                result = mid;
                end = mid - 1;
            } else if (arry[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}

class InfinetArray{
    public int fun(int arry[],int key,int start,int end) {
        while (start <= end) {
            if (arry[end] < key) {
                start=end;
                end = end *2;
            }
            if (arry[end] == key) {
                return end;
            }
            else if (arry[end] > key) {
                int mid = start + (end - start) / 2;
                if (arry[mid] == key) {
                    return mid;
                }
                else if (arry[mid] > key) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}

class DescendingBinarySearch {
    //    desending sorted array find out element
    public int se(int list[]   , int  key,int start,int end) {

        while (start <= end) {
            int mid = start + (end - start)/ 2;
            if (list[mid] == key) {
                return mid;
            } else if (list[mid] > key) {
                start = mid + 1;

            } else if(list[mid] < key) {
                end = mid - 1;
            }
        }
        return -1;
    }
}

class FirstOcurrance {
    //    assending sorted array find out element first occurance
    public int se(int list[]  /* Array*/, int ele /* Element which we have to seach*/) {
        int start = 0;
        int end = list.length - 1;
        int result=-1;
        while (start <= end) {
            int mid = start + (end - start)/ 2;
            if (list[mid] == ele) {
                  /*
                  for first occurance don't return mid
                  result=mid;
                  end=mid-1;
                  for last occurance don't return mid
                  result=mid;
                  start=mid+1;
                   */
                result=mid;
                end=mid-1;
            } else if (list[mid] > ele) {
                start = mid + 1;

            } else if(list[mid] < ele) {
                end = mid - 1;
            }
        }
        return result;
    }
}

class LastOcurrance {
    //    assending sorted array find out element  last occurance
    public int se(int list[]  /* Array*/, int ele /* Element which we have to seach*/) {
        int start = 0;
        int end = list.length - 1;
        int result=-1;
        while (start <= end) {
            int mid = start + (end - start)/ 2;
            if (list[mid] == ele) {
                  /*
                  for first occurance don't return mid
                  result=mid;
                  end=mid-1;
                  for last occurance don't return mid
                  result=mid;
                  start=mid+1;
                   */
                result=mid;
                start=mid+1;
            } else if (list[mid] > ele) {
                start = mid + 1;

            } else if(list[mid] < ele) {
                end = mid - 1;
            }
        }
        return result;
    }
}

class NoOfRotation{
    //    we can find out index of minimum element
    public int fun(int arr[]){
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            int next=(mid+1)%arr.length;
            int previous=(mid+arr.length-1)%arr.length;
            if(arr[mid]<=arr[next] && arr[mid]<=arr[previous]){
                return mid;
            }
            else {
                if(arr[mid]>=arr[start] && arr[mid]<=arr[end]){ return start; }
                else if(arr[mid]>=arr[start]){start=mid+1;}
                else if(arr[mid]<=arr[end]){end=mid-1;}
            }
        }
        return -1;
//        System.out.println("No of rotation is : "+(arr.length-returned value));
//        (arr.length-returned value)
    }
}

class BinarySearch{
    public int  start;
    public  int end;
    public int fun(int arr[],int element,int start,int end){
        while (start<=end){
            int mid =start+(end-start)/2;

            if (arr[mid]==element){
                return mid;
            }
            else {
                if(arr[mid]<element){
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}

class NearlyBinarySearch{
    public int fun(int arr[],int element,int start,int end){
        while (start<=end){
            int mid =start+(end-start)/2;

            if (arr[mid]==element){return mid;}
            if (mid-1>=start && arr[mid-1]==element){return mid-1;}
            if (mid+1<=end && arr[mid+1]==element){return mid+1;}

            else {
                if(arr[mid]<element){
                    start=mid+2;
                }else {
                    end=mid-2;
                }
            }
        }
        return -1;
    }
}

class FllorBinarySearch{


    public int fun(int arr[],int element,int start,int end){
        int result=-1;
        while (start<=end){
            int mid =start+(end-start)/2;

            if (arr[mid]==element){
                return mid;
            }
            else {
                if(arr[mid]<element){
                    result=mid;
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
        }
        return result;
    }
}

class CeilingBinarySearch{
    public int fun(int arr[],int element,int start,int end){
        int result=-1;
        while (start<=end){
            int mid =start+(end-start)/2;
            if (arr[mid]==element){
                return mid;
            }
            else {
                if(arr[mid]<element){
                    start=mid+1;
                }else {
                    result=mid;
                    end=mid-1;
                }
            }
        }
        return result;
    }
}

class MinminumDiffrence{

    // how to call this class and function

//      int list[]={2,3,5,7,9,11,12,16,18};
//      MinminumDiffrence obj=new MinminumDiffrence();
//      int output=obj.minDiffranceValue(list,2);
//        if(output==00){
//          System.out.println(obj.ans1+ " and " + obj.ans2);
//      }
//        else{
//          System.out.println(output);
//      }

    public int  start;
    public  int end;
    public int ans1,ans2;

    public int minDiffranceValue(int arr[], int element){
        start=0;
        end=arr.length-1;

        while (start<=end){
            int mid =start+(end-start)/2;

            if (arr[mid]==element){
                return arr[mid];
            }
            else {
                if(arr[mid]<element){
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
        }

        int min=Math.min(Math.abs(arr[start]-element),Math.abs(arr[end]-element));
        if(Math.abs(arr[start]-element)==min &&Math.abs(arr[end]-element)==min){
            ans1=arr[start];
            ans2=arr[end];
            return  00;
        }
        else if(Math.abs(arr[start]-element)==min){
            return arr[start];
        }
        else{
            return  arr[end];
        }


    }
}




//incomplete
class AlphabteBinarySearch{
    public char fun(char arr[],char element,int start,int end){
        char result='#';
        while (start<=end){
            int mid =start+(end-start)/2;
            if ( arr[mid] ==  element){
                start=mid+1;
                return arr[start];
            }
            else {
                if(( arr[mid])< ( element)){
                    start=mid+1;
                }else {
                    end=mid-1;
                    result=arr[mid];
                }
            }
        }
        return result;
    }
}

// incomplete
class PeekValue{

    public int getPeek(int arr[]){
        int  start=0 ;
        int end=arr.length-1;
        int lastIndex=arr.length-1;

        while(start<=end){

            int mid =start + (end-start)/2;
            if(arr[mid]>0 && arr[mid]<lastIndex-1){
                if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                    return mid;
                }else if(arr[mid+1]>arr[mid]){
                    start=mid+1;
                }else if(arr[mid-1]>arr[mid]){
                    end=mid-1;
                }
            }else if(mid==0){
                if(arr[0]>arr[1]) return 0;
                else return 1;
            }else if(mid==lastIndex){
                if(arr[lastIndex]>arr[lastIndex-1]) return lastIndex;
                else return lastIndex -1;
            }
        }
        return -1;
    }
}




