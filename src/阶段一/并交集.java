package 阶段一;

public class 并交集 {

    private int[] roots;

    public 并交集(int N) {
        for (int i = 0; i < N; i++) {
            roots[i] = i;
        }
    }


    public int findRoot(int i) {
        int root = i;
        while (root != roots[root]) {
            root = roots[root];
        }
        while (i != roots[i]) {
            int temp = roots[i];
            roots[i] = root;
            i = temp;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int qroot = findRoot(p);
        int proot = findRoot(q);
        roots[qroot] = proot;
    }

}
