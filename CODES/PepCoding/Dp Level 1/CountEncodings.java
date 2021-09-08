import java.util.Scanner;

public class CountEncodings {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String input=scn.nextLine();


        int[] dp=new int[input.length()];
        dp[0]=1;

        for(int i=1;i<input.length();i++){
            if(input.charAt(i-1)=='0' && input.charAt(i)=='0'){
                dp[i]=0;
            }else if(input.charAt(i-1)=='0' && input.charAt(i)!='0'){
                dp[i]=dp[i-1];
            }else if(input.charAt(i-1)!='0' && input.charAt(i)=='0'){
                if(Integer.parseInt(input.substring(i-1,i+1))<=26){
                    dp[i]=(i>1?dp[i-2]:1);
                }else{
                    dp[0]=0;
                }
            }else{
                if(Integer.parseInt(input.substring(i-1,i+1))<=26){
                    dp[i]=(i>1?dp[i-2]:1)+dp[i-1];
                }else{
                    dp[i]=dp[i-1];
                }
            }
        }

        System.out.println(dp[input.length()-1]);

    }
}
