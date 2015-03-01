package Part2.Wk2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanxiao on 17/02/15.
 */
public class EdgeWeightedGraph {
    @Getter
    private final int V;
    private final List<List<Integer>> adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj.get(v);
    }
}
