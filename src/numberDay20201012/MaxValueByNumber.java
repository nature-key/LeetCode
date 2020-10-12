package numberDay20201012;

import java.util.PriorityQueue;

public class MaxValueByNumber {

    private PriorityQueue<Integer> p;
    private int k;

    public MaxValueByNumber(int k, int[] a) {
        this.k = k;
        p = new PriorityQueue<>(k);
        for (int i : a) {
//            p.offer(i);
            add(i);
        }
    }

    public int add(int n) {
        if (p.size() < k) {
            p.offer(n);
        } else if (p.peek() < n) {
            p.poll();
            p.offer(n);
        }
        return p.peek();
    }


    public PriorityQueue<Integer> getP() {
        return p;
    }

    public void setP(PriorityQueue<Integer> p) {
        this.p = p;
    }
}
