package common;

public class UnionFind {
    int count;
    int[] parent;
    int[] size;

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n+1];
        size = new int[n+1];
        for (int i = 0; i<=n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        return parent[i] == i ? i : find(parent[i]);
    }

    public void union(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);
        if (root1 != root2) {
            if (size[root1] > size[root2]) {
                parent[root2] = root1;
                size[root1] += size[root2];
            } else {
                parent[root1] = root2;
                size[root2] += size[root1];
            }
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
