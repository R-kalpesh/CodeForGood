import java.util.Stack;

public class RemoveSameChar {
    public String removeDuplicates(String s, int k) {

        Stack<Character> st = new Stack<>();
        Stack<Integer> pre = new Stack<>();
        int count=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(st.size()==0){
                st.push(ch);
                count++;
            }
            else if(ch==st.peek()){
                st.push(ch);
                count++;
                if(count==k ){
                    while (count!=0){
                        st.pop();
                        count--;
                    }
                    if(pre.size()!=0){
                        count=pre.pop();
                    }
                }
            }else{
                st.push(ch);
                pre.push(count);
                count=1;
            }
        }

        StringBuilder ans=new StringBuilder();
        while (st.size()!=0){
            ans.append(st.pop());
        }

        ans.reverse();

        return ans.toString();

    }
}
