package doordash;

import java.util.HashSet;
import java.util.Set;

public class SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        int m = strs.length, count = 0;
        Set<String> visited = new HashSet<>();
        for (String str : strs) {
            if (visited.add(str)) {
                dfs(str, strs, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(String str, String[] strs, Set<String> visited) {
        for (String s : strs) {
            if (!visited.contains(s)) {
                if (isSimilar(str, s)) {
                    visited.add(s);
                    dfs(s, strs, visited);
                }
            }
        }
    }

    public int numSimilarGroupsUF(String[] strs) {
        int m = strs.length;
        UnionFind uf = new UnionFind(m);
        for (int i=0; i<m; i++) {
            for (int j=i+1; j<m; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getSize();
    }

    private boolean isSimilar(String s1, String s2) {
        int count = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }

        return count == 2 || count == 0;
    }

    class UnionFind {
        int cap;
        int[] parent;
        int[] size;

        public UnionFind (int n) {
            this.cap = n;
            parent = new int[n];
            size = new int[n];
            for (int i=0; i<n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find (int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = find(parent[i]);

            return parent[i];
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                if (size[rootA] > size[rootB]) {
                    parent[rootB] = rootA;
                    size[rootA] += size[rootB];
                } else {
                    parent[rootA] = rootB;
                    size[rootB] += size[rootA];
                }
                cap--;
            }
        }

        public int getSize() {
            return cap;
        }
    }

}
