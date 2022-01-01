package 阶段热身.number202103.numberDay20210328;

public class UnionFind {

    private int[] parent;

    private int count;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;
    }


    private int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void unionset(int i, int j) {

        int rootA = find(i);
        int rootB = find(j);
        if (rootA == rootB) {
            return;
        }

        parent[rootA] = rootB;
        count--;
    }

    public int getCount() {
        return count;
    }
}
