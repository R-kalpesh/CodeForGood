import java.util.*;

public class Main {

    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int vtces = scn.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = scn.nextInt();
        for (int i = 0; i < edges; i++) {

            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        boolean[] vis = new boolean[vtces];
        // int src = scn.nextInt();
        // int dest = scn.nextInt();

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for (int i = 0; i < vtces; i++) {
            if (vis[i] == false) {
                comps.add(isConnected(graph, i, vis));
            }
        }

        if (comps.size() == 1) {
            System.err.println("true");
        } else {
            System.out.println("false");
        }

    }

    static String longPath = "", sortPath = "", maxValuePath = "", minValuePath = "";
    static Integer max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static ArrayList<String> allString = new ArrayList<>();

    static void allFun(ArrayList<Edge>[] graph, int src, int dest, int ver, boolean[] vis, String path, int val) {

        // allFun(graph, src, dest, vtces, vis, "" + src, 0);

        // Collections.sort(allString, Collections.reverseOrder());

        // System.out.println("sort length string: " + allString.get(0));
        // System.out.println("long path : " + allString.get(allString.size() - 1));
        // System.out.println("maxValuePath : " + max + " @ " + maxValuePath);
        // System.out.println("minValuePath : " + min + " @ " + minValuePath);

        if (src == dest) {

            allString.add(path);

            if (longPath.length() < path.length()) {
                longPath = path;
            }
            if (max < val) {
                max = val;
                maxValuePath = path;
            }
            if (min > val) {
                min = val;
                minValuePath = path;
            }

        }
        vis[src] = true;
        for (Edge x : graph[src]) {
            if (vis[x.nbr] == false) {
                allFun(graph, x.nbr, dest, ver, vis, path + x.nbr, val + x.wt);
            }
        }
        vis[src] = false;
    }

    static void printPath(ArrayList<Edge>[] graph, int src, int dest, int ver, boolean[] vis, String path) {
        if (src == dest) {
            System.out.println(path);
            return;
        }

        vis[src] = true;
        for (Edge x : graph[src]) {
            if (vis[x.nbr] == false) {
                printPath(graph, x.nbr, dest, ver, vis, path + x.nbr);
            }
        }
        vis[src] = false;
    }

    static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, int ver, boolean[] vis) {

        if (src == dest)
            return true;
        vis[src] = true;

        for (Edge x : graph[src]) {
            if (vis[x.nbr] == false) {
                boolean tempAns = hasPath(graph, x.nbr, dest, ver, vis);

                if (tempAns == true)
                    return true;
            }
        }
        return false;

    }

    static ArrayList<Integer> isConnected(ArrayList<Edge>[] graph, int src, boolean[] vis) {

        // ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        // for (int i = 0; i < vtces; i++) {
        // if (vis[i] == false) {
        // comps.add(isConnected(graph, i, vis));
        // }
        // }

        // System.out.println(comps);

        ArrayList<Integer> comp = new ArrayList<>();
        Queue<Integer> q = new LinkedList();

        q.add(src);
        comp.add(src);
        vis[src] = true;

        while (q.size() > 0) {
            int temp = q.poll();
            for (Edge e : graph[temp]) {
                if (vis[e.nbr] == false) {
                    q.add(e.nbr);
                    comp.add(e.nbr);
                    vis[e.nbr] = true;
                }
            }
        }
        return comp;
    }
}
