import java.util.ArrayList;
import java.util.Scanner;


// Todo: question is for given no of stairs u can climb up 1,2,3 stairs at a time
// Todo: print all combinations of stairs    

public class PrintAllStairs {

    static ArrayList<String> paths=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        helper(n,"");
        for(String path:paths){
            System.out.println(path);
        }
        scn.close();
    }



    static void helper(int n,String str){
        
        if(n<0)  return;

        else if(n==0)   paths.add(str);
        
            helper(n-1,str+" 1");          
            helper(n-2,str+" 2");
            helper(n-3,str+" 3");
    }


}
