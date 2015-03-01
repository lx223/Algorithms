package Part2.Wk1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanxiao on 14/02/15.
 */
public class Graph {

    @Getter
    private final int V;
    private List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }
}
