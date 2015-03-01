package Part2.Wk1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanxiao on 17/02/15.
 */
public class Digraph {
    @Getter
    private final int V;
    private List<List<Integer>> adj;

    public Digraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }

    public Digraph reverse() {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                R.addEdge(w, v);
            }
        }
        return R;
    }
}
