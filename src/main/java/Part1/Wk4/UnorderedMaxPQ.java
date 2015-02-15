package Part1.Wk4;

/**
 * Created by lanxiao on 15/02/15.
 */
public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;

    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public UnorderedMaxPQ<Key> insert(Key key) {
        pq[N++] = key;
        return this;
    }

    public Key deleteMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (less(pq[max], pq[i])) max = i;
        }
        exch(pq, max, N - 1);
        return pq[--N];
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
        UnorderedMaxPQ<Integer> pq1 = new UnorderedMaxPQ<>(10);
        pq1.insert(2).insert(4).insert(2);
        System.out.println(pq1.deleteMax());
        System.out.println(pq1.deleteMax());
    }
}
