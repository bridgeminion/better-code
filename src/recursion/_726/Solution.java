package recursion._726;

import java.util.*;

/**
 * Given a chemical formula (given as a string), return the count of each atom.
 *
 * An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.
 *
 * 1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.
 *
 * Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.
 *
 * A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.
 *
 * Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 *
 * Example 1:
 * Input:
 * formula = "H2O"
 * Output: "H2O"
 * Explanation:
 * The count of elements are {'H': 2, 'O': 1}.
 * Example 2:
 * Input:
 * formula = "Mg(OH)2"
 * Output: "H2MgO2"
 * Explanation:
 * The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * Example 3:
 * Input:
 * formula = "K4(ON(SO3)2)2"
 * Output: "K4N2O14S4"
 * Explanation:
 * The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
 */
public class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = helper(formula);
        return map.entrySet().stream().sorted(Map.Entry.comparingByKey()).map(entry -> entry.getValue() > 1 ? String.format("%s%s", entry.getKey(), entry.getValue()) : entry.getKey()).reduce("", String::concat);
    }

    private Map<String, Integer> helper(String formula) {
        Map<String, Integer> map = new HashMap<>();
        int i=0;
        while (i < formula.length()) {
            char c = formula.charAt(i++);
            if (c == '(') {
                int start = i, count = 0;
                while (i < formula.length()) {
                    if (formula.charAt(i) == '(') {
                        count++;
                    } else if (formula.charAt(i) == ')') {
                        count--;
                    }
                    if (count == 0) break;
                    i++;
                }
                Map<String, Integer> result = helper(formula.substring(start, ++i));
                start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                String countStr = formula.substring(start, i);
                int cnt = countStr.equals("") ? 1 : Integer.parseInt(countStr);
                result.entrySet().forEach(entry -> map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0)+((int)entry.getValue() * cnt)));

            } else {
                int start = i-1;
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String token = formula.substring(start, i);
                start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                String countStr = formula.substring(start, i);
                int count = countStr == "" ? 0 : Integer.parseInt(countStr);
                map.put(token, map.getOrDefault(token, 0) + count);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countOfAtoms("K4(ON(SO3)2)2");
    }
}
