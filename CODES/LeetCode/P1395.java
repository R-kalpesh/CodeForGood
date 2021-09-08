public class P1395{
    public static void main(String[] args) {
        int[] arr=new int[]{2,1,3};

        int ans=fun(arr);
        System.out.println(ans);
    }

    static int fun(int[] arr){
        
        if(arr.length<3) return 0;

        int res=0;
        int[][] dp=new int[2][arr.length];
        
        for(int i=1;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]) dp[0][i]++;
                if(arr[i]>arr[j]) dp[1][i]++;
            }
        }

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]) res+=dp[0][j];
                if(arr[i]>arr[j]) res+=dp[1][j];
            }
        }

        return res;
    }
}