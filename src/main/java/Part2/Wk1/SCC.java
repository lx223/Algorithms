package Part2.Wk1;

/**
 * Created by lanxiao on 17/02/15.
 */
public class SCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public SCC(Digraph digraph) {
        marked = new boolean[digraph.getV()];
        id = new int[digraph.getV()];
        count = 0;
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph.reverse());
        for (int v : depthFirstOrder.reversePost()) {
            if (!marked[v]) {
                dfs(digraph, v);
                count++;
            }
        }
    }

    public void dfs(Digraph digraph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) {
                dfs(digraph, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }
}
