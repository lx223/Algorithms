package Part1.Wk2;

import java.util.Stack;

/**
 * Created by lanxiao on 15/02/15.
 */
public class ShellSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        Stack<Integer> seq = getSequence(length);

        while (!seq.isEmpty()) {
            int h = seq.pop();
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
        }
    }

    private Stack<Integer> getSequence(int length) {
        Stack<Integer> sequence = new Stack<>();

        int h = 1;
        while (h < length) {
            sequence.push(h);
            h = 3 * h + 1;
        }
        return sequence;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 7, 5};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(a);
        shellSort.show(a);

    }
}
