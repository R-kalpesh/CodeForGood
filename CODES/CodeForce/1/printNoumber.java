import java.util.Scanner;

public class printNoumber{
    public static void main(String[] args) {
        
        String[] list=new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        Scanner scn = new Scanner(System.in);

        int input=scn.nextInt();
        
        helper(input,list);
    }

     
    

    static void helper(int k,String[] li){

        if(k==0)  return ;
        

        helper(k/10,li);

        System.out.print(li[k%10]+" ");

        return;

    }
}