package com.company;

public class Main {

    public static void main(String[] args) {
	        String str="xxxxxabc";
        System.out.println(removeChar(str));
    }

    public static String removeChar(String str){
        if(str.isEmpty()){
            return str;
        }
        String ans= "";
        if(str.charAt(0)!='x'){
            ans= ans + str.charAt(0);
        }
        String smallAns=removeChar(str.substring(1));

        return ans+smallAns;
    }
}
