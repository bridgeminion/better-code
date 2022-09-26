package top_interview_questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * String.valueOf(char[]) as key
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = new char[26];
            for (char c : str.toCharArray()) {
                array[c - 'a']++;
            }
            String key = String.valueOf(array);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams instance = new GroupAnagrams();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(instance.groupAnagrams(strs));
    }

}
