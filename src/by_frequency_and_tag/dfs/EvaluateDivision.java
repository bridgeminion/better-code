package by_frequency_and_tag.dfs;

import java.util.*;

public class EvaluateDivision {
    class Pair {
        String s;
        double value;
        public Pair (String s, double value) {
            this.s = s;
            this.value = value;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i=0; i<values.length; i++) {
            List<String> list = equations.get(i);
            map.putIfAbsent(list.get(0), new ArrayList<>());
            map.putIfAbsent(list.get(1), new ArrayList<>());
            map.get(list.get(0)).add(new Pair(list.get(1), values[i]));
            map.get(list.get(1)).add(new Pair(list.get(0), 1.0/values[i]));
        }
        double[] result = new double[queries.size()];
        int i=0;
        for (List<String> query : queries) {
            if (!map.containsKey(query.get(0)) || !map.containsKey(query.get(1))) {
                result[i++] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                visited.add(query.get(0));
                result[i++] = dfs(map, query.get(0), query.get(1), 1.0, visited);
            }
        }

        return result;
    }

    private double dfs(Map<String, List<Pair>> map, String curr, String target, double value, Set<String> visited)
    {
        if (curr.equals(target)) {
            return value;
        }
        if (map.containsKey(curr)) {
            for (Pair pair : map.get(curr)) {
                if (visited.add(pair.s)) {
                    double result = dfs(map, pair.s, target, value * pair.value, visited);
                    if (result != -1.0) {
                        return result;
                    }
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        EvaluateDivision app = new EvaluateDivision();
        List<List<String>> equations = Arrays.asList(Arrays.asList("x1", "x2"), Arrays.asList("x2", "x3"), Arrays.asList("x3", "x4"), Arrays.asList("x4", "x5"));
        double[] values = {3.0,4.0,5.0,6.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("x1", "x5"), Arrays.asList("x5", "x2"), Arrays.asList("x2", "x4"), Arrays.asList("x2", "x2"), Arrays.asList("x2", "x9"), Arrays.asList("x9", "x9"));
        System.out.println(app.calcEquation(equations, values, queries));
    }

}
