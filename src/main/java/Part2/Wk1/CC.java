package Part2.Wk1;

/**
 * Created by lanxiao on 17/02/15.
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph graph) {
        marked = new boolean[graph.getV()];
        id = new int[graph.getV()];
        count = 0;
        for (int v = 0; v < graph.getV(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
                count++;
            }
        }
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    public boolean connected(int w, int v) {
        return id[w] == id[v];
    }
}
