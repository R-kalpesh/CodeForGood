import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {

        StringBuilder ans1=new StringBuilder();
        String a="";
        Stack<Character> ans=new Stack<>();
        Stack<Integer> no=new Stack<>();
         for(char x:s.toCharArray()){
             if(Character.isDigit(x)){
                 no.push((x-'0'));
             }
             else{
                 ans.push(x);
             }
         }

         while (ans.size()>0){
             while ( ans.peek()!='['){
                 if(ans.peek()==']'){
                     ans.pop();
                 }
                 if(ans.peek()==']'){
                     while ( ans.peek()!='[') {
                         if (ans.peek() == ']') {
                             ans.pop();
                         } else {
                             a = ans.pop() + a;
                         }
                     }
                     ans.pop();
                     for(int i=0;i<no.peek();i++){
                         ans1.insert(0,a);
                     }
                     a="";
                     no.pop();
                 }
                 else{
                     a=ans.pop()+a;
                 }
             }
             ans.pop();
             for(int i=0;i<no.peek();i++){
                 ans1.insert(0,a);
             }
             a="";
             no.pop();

         }

         return  ans1.toString();
    }
}
