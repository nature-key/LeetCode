package 阶段一;

public class 省份数量朋友圈 {



    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        UnionSet set = new UnionSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(isConnected[i][j]==1){
                    set.union(i,j);
                }
            }
        }
        return set.count;
    }



    class  UnionSet{
        int[] root;
        int count;

        public UnionSet(int n) {
            root=new int[n];
            for (int i = 0; i < n; i++) {
                root[i]=i;
            }
            count=n;
        }


        public int find(int i){
            if(i==root[i]){
                return i;
            }
            return root[i]=find(i);
        }

        public void union(int p, int q){
            int rootP = find(p);
            int rootq = find(q);

            if(rootP==rootq){
                return;
            }
            root[rootP]=rootq;
            count--;
        }


    }



}
