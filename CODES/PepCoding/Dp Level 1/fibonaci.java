import java.util.Scanner;

// Todo : For given No print fibonaci value
public class fibonaci{
    
    public static void main(String[] args) {

        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();

        int ans=memoizationDP(n,new int[n+1]);

        System.out.println(ans);
        scn.close();
    }

    static int memoizationDP(int n,int[] arrayOfCalculatedAns){

        if(n==0 || n==1)    return n;

        if(arrayOfCalculatedAns[n]!=0)   return arrayOfCalculatedAns[n];
        
        int fib1=memoizationDP(n-1,arrayOfCalculatedAns);
        int fib2=memoizationDP(n-2,arrayOfCalculatedAns);

        arrayOfCalculatedAns[n]=fib1+fib2;
        
        return arrayOfCalculatedAns[n];
        
    }

    static int recursive(int n){

        if(n==0 || n==1) return n;

        int fib1=recursive(n-1);
        int fib2=recursive(n-2);

        return fib1+fib2;
    }
    
}