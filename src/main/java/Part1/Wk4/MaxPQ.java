package Part1.Wk4;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public MaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1]; // incremented by 1 to allow easier maths
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public MaxPQ<Key> insert(Key key) {
        pq[++N] = key;
        swim(N);
        return this;
    }

    public Key delMax() {
        exch(pq, N, 1);
        Key max = pq[N--];
        sink(1);
        pq[N + 1] = null;
        return max;
    }

    private void swim(int i) {
        while (i > 1 && less(pq[i / 2], pq[i])) {
            exch(pq, i / 2, i);
            i /= 2;
        }
    }

    private void sink(int i) {
        while (2 * i <= N) {
            int j = 2 * i;
            if (j < N && less(pq[j], pq[j + 1])) j++;
            if (!less(pq[i], pq[j])) break;
            exch(pq, i, j);
            i = j;
        }
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0; // a < b?
    }

    private void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<>(10);
        maxPQ.insert(2).insert(34).insert(1);

        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
    }
}
