package graph._399;

import java.util.*;
import java.util.stream.Collectors;

/**
 * You are given equations in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating-point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 */
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i=0; i<values.length; i++) {
            String from = equations.get(i).get(0), to = equations.get(i).get(1);
            map.putIfAbsent(from, new HashMap<>());
            map.putIfAbsent(to, new HashMap<>());
            map.get(from).put(to, values[i]);
            map.get(to).put(from, 1.0/values[i]);
        }
        double[] answer = new double[queries.size()];
        int i= 0;
        for (List<String> query : queries) {
            answer[i++] = dfs(query.get(0), query.get(1), map, 1.0, new HashSet<>());
        }

        return answer;
    }

    private double dfs(String start, String end, Map<String, Map<String, Double>> map, double value, HashSet<Object> visited) {
        if (!map.containsKey(start)) {
            return -1;
        }
        if (start.equals(end)) {
            return value;
        }
        if (!visited.add(start)) {
            return -1;
        }
        double result = -1;
        for (Map.Entry<String, Double> entry : map.get(start).entrySet()) {
            result = dfs(entry.getKey(), end, map, value * entry.getValue(), visited);
            if (result != -1) {
                break;
            }
        }
        visited.remove(start);
        return result;
    }

    public static void main(String[] args) {
//        List<String> a = new ArrayList<>();
//        a.add("a");
//        a.add("b");
//        a.stream().map(s -> "xxx" + s).collect(Collectors.toMap())
    }
}
