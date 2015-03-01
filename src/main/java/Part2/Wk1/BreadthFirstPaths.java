package Part2.Wk1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lanxiao on 17/02/15.
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BreadthFirstPaths(Graph graph, int s) {
        marked = new boolean[graph.getV()];
        edgeTo = new int[graph.getV()];
        this.s = s;
        bfs(graph, s);
    }

    private void bfs(Graph graph, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        marked[v] = true;

        while (!queue.isEmpty()) {
            v = queue.remove();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    queue.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int w = v; w != s; w = edgeTo[w]) {
            path.add(w);
        }
        path.add(s);
        return path;
    }

}
