package Part1.Wk4;

import Part1.Wk2.Sort;

public class HeapSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = N / 2; i >= 1; i--) sink(a, i, N);
        while (N > 1) {
            exch(a, N - 1, 0);
            sink(a, 1, --N);
        }
    }

    private void sink(Comparable[] a, int i, int N) {
        while (i * 2 <= N) {
            int j = i * 2;
            if (j < N && less(a[j - 1], a[j])) j++;
            if (!less(a[i - 1], a[j - 1])) break;
            exch(a, i - 1, j - 1);
            i = j;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {3, 5, 2, 4, 7};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(a);
        heapSort.show(a);
    }
}
