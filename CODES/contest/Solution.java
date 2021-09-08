import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution { 
	public static void main(String[] args) {
		int n=5;
		int[] arr=new int[]{55,32,23,46,88};
		int ans=RulingPair(arr, n);
		System.out.println(ans);

		// System.out.println(sumFinder(55));;

		
	}

	static int RulingPair(int arr[], int n) {

		
		HashMap<Integer,PriorityQueue<Integer>> map=new HashMap<>();
		
		
        for(int i=0;i<n;i++){
			int a=sumFinder(arr[i]);
			sum=0;
			if(map.containsKey(a)){
				map.get(a).add(arr[i]);
			}else{
				map.put(a, new PriorityQueue<>(Collections.reverseOrder()));
				map.get(a).add(arr[i]);
			}
		}

		int max=Integer.MIN_VALUE;
		for(int key:map.keySet()){
			if(map.get(key).size()>=2){
				int aa=map.get(key).poll()+map.get(key).poll();
				if(max<aa) max=aa;
			}
		}

		if(max==Integer.MIN_VALUE) return -1;
		return max;
	}
	
	
	static int sum=0;
	static int sumFinder(int s){
		if(s==0) return 0;

		sum+=s%10;

		sumFinder(s/10);

		
		return sum;
		
	}
} 