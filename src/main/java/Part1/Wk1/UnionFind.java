package Part1.Wk1;

/**
 * Created by Lan on 21/01/2015.
 */
public class UnionFind {
    private int[] pts;
    private int[] sz;

    public UnionFind(final int n){
        pts = new int[n];
        sz = new int[n];

        for (int i = 0; i < n; i++){
            pts[i] = i;
            sz[i] = 1;
        }
    }

    public void union(final int p, final int q){
        int i = root(p);
        int j = root(q);
        if (sz[i] >  sz[j]){
            pts[j] = pts[i];
            sz[j] += sz[i];
        }else{
            pts[i] = pts[j];
            sz[i] += sz[j];
        }
    }

    public boolean connected(final int i, final int j){
        return pts[i] == pts[j];
    }

    private int root(final int i){
        int root = i;
        while(root != pts[root]){
            pts[root] = pts[pts[root]];
            root = pts[root];
        }
        return root;
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);

        unionFind.union(1, 2);
        unionFind.union(3, 2);
        unionFind.union(3, 4);
        if (unionFind.connected(1, 4)) {
            System.out.println("HelloWorld!");
        }
    }
}
