import java.util.HashMap;

public class EvaluateExpressiontoTrueBooleanParenthesizationRecursive{
    public static void main(String[] args) {
        String str="T|T&F^T";
        int ans=funDP(str, 0, str.length()-1, true);
        System.out.println(ans);

    }

    static int fun(String str,int i, int j,boolean isTure){

        if(i>j) return 0;

        if(i==j){
            if(isTure==true){
                return str.charAt(i)=='T'?1:0;
            }else{
                return str.charAt(i)=='F'?1:0;
            }
        }

        int ans=0;

        for(int k=i+1;k<j;k+=2){
            int leftTrue=fun(str, i, k-1, true);
            int leftFalse=fun(str, i, k-1, false);
            int rightTrue=fun(str, k+1, j, true);
            int rightFalse=fun(str, k+1, j, false);

            if(str.charAt(k)=='|'){
                if(isTure==true){
                    ans+=leftTrue*rightTrue+leftTrue*rightFalse+leftFalse*rightTrue;
                }else{
                    ans+=leftFalse*rightFalse;
                }
            }else if(str.charAt(k)=='&'){
                if(isTure==true){
                    ans+=leftTrue*rightTrue;
                }else{
                    ans+=leftTrue*rightFalse+leftFalse*rightTrue+leftFalse*rightFalse;
                }
            }else{
                if(isTure==true){
                    ans+=leftTrue*rightFalse+leftFalse*rightTrue;
                }else{
                    ans+=leftTrue*rightTrue+leftFalse*rightFalse;
                }
            }
        }
        return ans;

    }
    
    static HashMap<String,Integer> map=new HashMap<>();

    static int funDP(String str,int i, int j,boolean isTrue){

        if(i>j) return 0;

        if(i==j){
            if(isTrue==true){
                return str.charAt(i)=='T'?1:0;
            }else{
                return str.charAt(i)=='F'?1:0;
            }
        }

        if(map.containsKey(i+"_"+j+"_"+isTrue)){
            return map.get(i+"_"+j+"_"+isTrue);
        }

        int ans=0;

        for(int k=i+1;k<j;k+=2){

            int leftFalse,leftTrue,rightFalse,rightTrue;

            if(map.containsKey(i+"_"+(k-1)+"_"+true)){
                leftTrue=map.get(i+"_"+(k-1)+"_"+true); 
            }else{
                leftTrue=funDP(str, i, k-1, true);
            }

            if(map.containsKey(i+"_"+(k-1)+"_"+false)){
                leftFalse=map.get(i+"_"+(k-1)+"_"+false); 
            }else{
                leftFalse=funDP(str, i, k-1, false);
            }

            
            if(map.containsKey((k+1)+"_"+j+"_"+true)){
                rightTrue=map.get((k+1)+"_"+j+"_"+true); 
            }else{
                rightTrue=funDP(str, k+1, j, true);
            }

            if(map.containsKey((k+1)+"_"+j+"_"+false)){
                rightFalse=map.get((k+1)+"_"+j+"_"+false); 
            }else{
                rightFalse=funDP(str, k+1, j, false);
            }


            if(str.charAt(k)=='|'){
                if(isTrue==true){
                    ans+=leftTrue*rightTrue+leftTrue*rightFalse+leftFalse*rightTrue;
                }else{
                    ans+=leftFalse*rightFalse;
                }
            }else if(str.charAt(k)=='&'){
                if(isTrue==true){
                    ans+=leftTrue*rightTrue;
                }else{
                    ans+=leftTrue*rightFalse+leftFalse*rightTrue+leftFalse*rightFalse;
                }
            }else if(str.charAt(k)=='^'){
                if(isTrue==true){
                    ans+=leftTrue*rightFalse+leftFalse*rightTrue;
                }else{
                    ans+=leftTrue*rightTrue+leftFalse*rightFalse;
                }
            }
        
        }

        map.put(i+"_"+j+"_"+isTrue, ans);

        return ans;

    }

}