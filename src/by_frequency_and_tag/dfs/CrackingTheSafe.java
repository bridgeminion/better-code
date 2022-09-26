package by_frequency_and_tag.dfs;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        int ways = (int)Math.pow(k, n);
        Set<String> set = new HashSet<>();
        StringBuilder first = new StringBuilder();
        for (int i=0; i<n; i++) {
            first.append("0");
        }
        set.add(first.toString());
        dfs(n, k, first, ways, set);

        return first.toString();
    }

    private boolean dfs(int n, int k, StringBuilder sb, int ways, Set<String> set) {
        if (set.size() == ways) {
            return true;
        }
        String postfix = sb.substring(sb.length() - n + 1);
        for (int i=0; i<k; i++) {
            String next = postfix + i;
            if (!set.contains(next)) {
                set.add(next);
                sb.append(i);
                if (dfs(n, k, sb, ways, set)) {
                    return true;
                }
                set.remove(next);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CrackingTheSafe app = new CrackingTheSafe();
        System.out.println(app.crackSafe(2, 2));
    }

}
