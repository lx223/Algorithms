package Part1.Wk2;


/**
 * Created by lanxiao on 15/02/15.
 */
abstract public class Sort {
    abstract protected void sort(Comparable[] a);

    protected boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    protected void show(Comparable[] a) {
        for (Comparable i : a) System.out.println(i);
    }
}
