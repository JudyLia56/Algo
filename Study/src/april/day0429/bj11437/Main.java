package april.day0429.bj11437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parent;
    static boolean[] visited;
    static Node[] graph;

    static class Node {
        int vertex;
        int depth;
        Node link;

        public Node(int vertex, Node link, int depth) {
            super();
            this.vertex = vertex;
            this.link = link;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new Node[N + 1];

        for (int i = 1; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start] = new Node(end, graph[start], 0);
            graph[end] = new Node(start, graph[end], 0);
        }
        dfs(1, 0);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
            sb.append(lca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    static void dfs(int v, int d) {
        visited[v] = true;
        graph[v].depth = d;

        for (Node temp = graph[v]; temp != null; temp = temp.link) {
            if (!visited[temp.vertex]) {
                parent[temp.vertex] = v;
                dfs(temp.vertex, d + 1);
            }
        }
    }

    static int lca(int a, int b) {
        while (graph[a].depth != graph[b].depth) {
            if (graph[a].depth > graph[b].depth)
                a = parent[a];
            else 
                b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}