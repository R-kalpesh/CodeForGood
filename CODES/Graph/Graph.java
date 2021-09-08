import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    private LinkedList<Integer> adj[];

    public  Graph(int v){
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<Integer>();
        }
    }

    public void addEdge(int source,int destination){
        adj[destination].add(source);
        adj[source].add(destination);
    }

    public int Bfs(int source,int desti){
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[adj.length];
        int[] par=new int[adj.length];

        q.add(source);
        par[source]=-1;
        visited[source]=true;

        while(!q.isEmpty()){
            int cur=q.poll();
            if(cur==desti) break;

            for(int neighbor:adj[cur]){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    q.add(neighbor);
                    par[neighbor]=cur;
                }
            }
        }


        int cur=desti;
        int dis=0;
        while(par[cur]!= -1){
            System.out.print(cur+" -> ");
            cur=par[cur];
            dis++;
        }

        return dis;

    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter no of vertcies");
        int v=scn.nextInt();
        System.out.println("Enter no of edges");
        int e=scn.nextInt();

        Graph graph=new Graph(v);
        System.out.println("Enter "+e+" edges");

        for(int i=0;i<e;i++){
            int sr=scn.nextInt();
            int ed=scn.nextInt();
            
            graph.addEdge(sr,ed);
        }

        System.out.println("Enter source and destination");
		
		int source = scn.nextInt();
		int destination = scn.nextInt();
        int ans=graph.Bfs(source, destination);
        System.out.println("Min Distance is :"+ans);
    }

    
}
