package Part2.Wk5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lanxiao on 15/02/15.
 */
public class TrieST<Value> {
    private static final int R = 256;
    private Node root = new Node();

    private class Node {
        protected Value val;
        protected Node[] next;
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public Value get(String key) {
        return get(root, key, 0);
    }

    public void delete(String key) {
        if (contains(key)) {
            Stack<Node> stack = new Stack<>();
            Node node = root;
            stack.push(node);
            for (int i = 0; i < key.length(); i++) {
                stack.push(node.next[key.charAt(i)]);
            }
            int index = key.length() - 1;
            node = stack.pop();
            node.val = null;
            while (node.val == null && index >= 0) {
                node = stack.pop();
                node.next[key.charAt(index)] = null;
                index--;
            }
        }
    }

    private Value get(Node node, String key, int d) {
        if (node == null) return null;
        if (d == key.length()) return node.val;
        char c = key.charAt(d);
        return get(node.next[c], key, d + 1);
    }

    private Node put(Node node, String key, Value val, int d) {
        if (node == null) node = new Node();
        if (d == key.length()) {
            node.val = val;
            return node;
        }
        char c = key.charAt(d);
        node.next[c] = put(node.next[key.charAt(d)], key, val, d + 1);
        return node;
    }

    public Iterable<String> keys() {
        Queue<String> queue = new LinkedList<>();
        collect(root, "", queue);
        return queue;
    }

    private void collect(Node node, String prefix, Queue<String> queue) {
        if (node == null) return;

        if (node.val != null) queue.add(prefix);
        for (char c = 0; c < R; c++) {
            collect(node.next[c], prefix + c, queue);
        }
    }

    public String longestPrefixOf(String query) {
        int length = search(root, query, 0, 0);
        return query.substring(0, length);
    }

    private int search(Node node, String query, int d, int length) {
        if (node == null) return length;
        if (node.val != null) length = d;
        if (d == query.length()) return length;
        char c = query.charAt(d);
        return search(node.next[c], query, d + 1, length);
    }
}
