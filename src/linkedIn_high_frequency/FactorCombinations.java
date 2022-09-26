package linkedIn_high_frequency;

import java.util.*;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(2, n, new ArrayList<>(), list);

        return list;
    }

    private void helper(int start, int n, List<Integer> array, List<List<Integer>> list) {
        if (n <= 1) {
            if (array.size() > 1) {
                list.add(new ArrayList(array));
                return;
            }
        }
        for (int i=start; i<=n; i++) {
            if (n%i == 0) {
                array.add(i);
                helper(i, n/i, array, list);
                array.remove(array.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        FactorCombinations app = new FactorCombinations();
//        List<List<Integer>> list = app.getFactors(8);
//        System.out.println(list);
        System.out.println(app.letterCombinations("23"));
    }

    public List<List<String>> letterCombinations(String digits) {
        List<List<String>> result = new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        dfs(digits, 0, new ArrayList<>(), result, map);

        return result;
    }

    private void dfs(String digits, int start, List<String> list, List<List<String>> result, Map<Character, List<String>> map) {
        if (start == digits.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i=start; i<digits.length(); i++) {
            char c = digits.charAt(i);
            for (String str : map.get(c)) {
                list.add(str);
                dfs(digits, i+1, list, result, map);
                list.remove(list.size()-1);
            }
        }
    }

}
