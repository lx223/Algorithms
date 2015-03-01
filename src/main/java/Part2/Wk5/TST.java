package Part2.Wk5;

/**
 * Created by lanxiao on 15/02/15.
 */
public class TST<Value> {
    private Node root;

    private class Node {
        protected Value val;
        protected char c;
        protected Node left, middle, right;

        protected Node(char c) {
            this.c = c;
        }
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node node, String key, Value val, int d) {
        char c = key.charAt(d);
        if (node == null) node = new Node(c);
        if (c > node.c) {
            node.right = put(node.right, key, val, d);
        } else if (c < node.c) {
            node.left = put(node.left, key, val, d);
        } else if (d < key.length() - 1) {
            node.middle = put(node.middle, key, val, d + 1);
        } else {
            node.val = val;
        }
        return node;
    }
}
