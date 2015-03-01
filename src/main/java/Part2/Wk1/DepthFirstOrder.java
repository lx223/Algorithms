package Part2.Wk1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lanxiao on 17/02/15.
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Deque<Integer> reversePost;
    private Queue<Integer> postOrder;
    private Queue<Integer> preOrder;

    public DepthFirstOrder(Digraph digraph) {
        marked = new boolean[digraph.getV()];
        reversePost = new ArrayDeque<>();
        postOrder = new LinkedList<>();
        preOrder = new LinkedList<>();
        for (int v = 0; v < digraph.getV(); v++) {
            if (!marked[v]) {
                dfs(digraph, v);
            }
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        preOrder.add(v);
        for (int w : digraph.adj(v))
            if (!marked[w])
                dfs(digraph, w);
        postOrder.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

    public Iterable<Integer> postOrder() {
        return postOrder;
    }

    public Iterable<Integer> preOrder() {
        return preOrder;
    }

    static public void main(String[] args) {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 3);
        digraph.addEdge(3, 2);
        digraph.addEdge(2, 4);
        digraph.addEdge(4, 2);

        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
        System.out.println(depthFirstOrder.reversePost());
    }
}
