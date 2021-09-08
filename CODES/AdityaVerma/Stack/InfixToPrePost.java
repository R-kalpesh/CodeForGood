import java.util.Stack;

public class InfixToPrePost {
    public static void main(String[] args) throws Exception {

        String exp ="a+b*c/d/e-f";

        // code
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<String> sign = new Stack<>();


        for(int i=0;i<exp.length();i++){
            String ch="";
            ch=ch+exp.charAt(i);


            if(ch.equals("(")){
                sign.push(ch);
            }
            else if(ch.equals("+") ||ch.equals("-") || ch.equals("*") ||ch.equals("/") ){
                while(sign.size()>0 && !sign.peek().equals("(") &&
                       pree(ch) <=pree(sign.peek()) ){
                    String op= sign.pop();

                    String val2=pre.pop();
                    String  val1=pre.pop();
                    String  ans1=op+val1+val2;
                    pre.push(ans1);

                    String post2=post.pop();
                    String post1=post.pop();
                    String  ans=post1+post2+op;
                    post.push(ans);

                }
                sign.push(ch);
            }
            else if(ch.equals(")")){
                while(sign.size()>0 && !sign.peek().equals("(")){
                    String op= sign.pop();

                    String val2=pre.pop();
                    String  val1=pre.pop();
                    String  ans1=op+val1+val2;

                    String post2=post.pop();
                    String post1=post.pop();
                    String  ans=post1+post2+op;

                    pre.push(ans1);
                    post.push(ans);

                }
                if(sign.size()>0){
                    sign.pop();
                }
            }
            else{
                    pre.push(ch);
                    post.push(ch);
            }
        }

        while(sign.size()>0){

            String op= sign.pop();

            String val2=pre.pop();
            String  val1=pre.pop();
            String  ans1=op+val1+val2;

            String post2=post.pop();
            String post1=post.pop();
            String  ans=post1+post2+op;

            pre.push(ans1);
            post.push(ans);

        }
        System.out.println(post.pop());
        System.out.println(pre.pop());
    }

    public static int pree(String op){
        if(op.equals("+") ||op.equals("-") )
            return 1;
        else
            return 2;

    }


}
