package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lan on 03/02/2015.
 */
public class MathOp {
    public static ArrayList<ArrayList<Integer>> subsets(int[] s) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int len = s.length;

        Arrays.sort(s);

        for (int i = 0; i < Math.pow(2, len); i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int tmp = i;
            for (int j = 0; j < len; j++) {
                int bit = tmp & 1;
                tmp >>= 1;
                if (bit == 1) {
                    list.add(s[j]);
                }
            }
            ret.add(list);
        }
        return ret;
    }

    static public char[] reverseWords(char[] s) {
        if (s.length == 0 || s.length == 1) return s;
        s = reverseStringInPlace(s, 0, s.length - 1);
        System.out.println(s);
        for (int start = 0; start < s.length; start++) {
            if (s[start] != ' ') {
                int end;
                for (end = start; end < s.length; end++) {
                    if (s[end] == ' ') {
                        break;
                    }
                }
                reverseStringInPlace(s, start, end - 1);
                start = end - 1;
            }
        }
        return s;
    }

    static public char[] reverseStringInPlace(char[] s, int start, int end) {
        while (start < end) {
            char swap = s[end];
            s[end] = s[start];
            s[start] = swap;
            start++;
            end--;
        }
        return s;
    }

    static public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        if (n == 0 || k == 0) return ans;
        if (n < k) return ans;

        LinkedList<Integer> prefix = new LinkedList<>();
        dfs(ans, prefix, n, 1, k);
        return ans;
    }

    static public void dfs(List<List<Integer>> ans, LinkedList<Integer> prefix, int n, int start, int k) {
        if (prefix.size() == k) {
            ans.add(prefix);
            return;
        }

        for (int i = start; i <= n; i++) {
            prefix.add(i);
            dfs(ans, prefix, n, i + 1, k);
            prefix.removeLast();
        }
    }

    static private class TreeNode {
        int val;
        List<TreeNode> children = new ArrayList<>();

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static private class Vertex {
        Vertex nextSibling;
        Vertex firstChild;

        public Vertex(Vertex firstChild, Vertex nextSibling) {
            this.nextSibling = nextSibling;
            this.firstChild = firstChild;
        }
    }

    static public Vertex transformTree(TreeNode root) {
        return transformTree(root, null);
    }

    static public Vertex transformTree(TreeNode node, Vertex nextSibling) {
        if (node == null) return null;
        if (!node.children.isEmpty()) {
            Vertex leftChild = null;
            for (int i = node.children.size() - 1; i >= 0; i--) {
                leftChild = transformTree(node.children.get(i), leftChild);
                if (i == 0) {
                    return new Vertex(leftChild, nextSibling);
                }
            }
        }
        return new Vertex(null, nextSibling);
    }

    static public void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        node3.children.add(node4);
        node3.children.add(node5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node1.children.add(node2);
        node1.children.add(node3);

        Vertex root = transformTree(node1);
        System.out.println();
    }

}
