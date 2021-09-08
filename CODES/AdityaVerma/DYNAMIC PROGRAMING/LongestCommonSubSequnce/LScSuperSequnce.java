public class  LScSuperSequnce  {
    public static void main(String[] args) {

        String x="geek";
        String y="eke";

        int ans=fun(x, y, x.length(), y.length());

        // sum of length of x and y sum - lcs's length
        int answer= x.length() + y.length() - ans ;

        System.out.println(answer);
    }



    static int fun(String x,String y,int xLength,int yLength){

        if(xLength==0 || yLength==0) return 0;

        if(x.charAt(xLength-1)==y.charAt(yLength-1)){
            return 1+fun(x, y, xLength-1, yLength-1);
        }else{
            return Math.max(fun(x, y, xLength, yLength-1), fun(x, y, xLength-1, yLength));
        }
    }
}


// static int myOwnWay(String x,String y,int xLength,int yLength){
        
//     int[] first=new int[26];
//     int[] second=new int[26];
    
    
//     for(int i=0;i<xLength;i++){
//         char ch=x.charAt(i);
//         first[ch-'0']=first[ch-'0']+1;
//     }
    
//     for(int i=0;i<yLength;i++){
//         char ch=y.charAt(i);
//         if(first[ch-'0']!=0){
//             second[ch-'0']=+1;
//             first[ch-'0']=-1;
//         }
//     }
    
//     int count=0;
//     for(int xx:second){
//         count=+xx;
//     }
    
//     return count ;
// }