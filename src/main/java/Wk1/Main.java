package Wk1;

public class Main {

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);

        unionFind.union(1,2);
        unionFind.union(3,2);
        unionFind.union(3,4);
        if(unionFind.connected(1,4)){
            System.out.println("HelloWorld!");
        }
    }
}
