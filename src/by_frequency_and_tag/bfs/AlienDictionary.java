package by_frequency_and_tag.bfs;

import java.util.*;

public class AlienDictionary {
    public String alienOrder1(String[] words) {

        Map<Character, Set<Character>> rules = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();

        for(String word : words) {
            for(char ch : word.toCharArray()) {
                rules.putIfAbsent(ch, new HashSet<>());
                inDegrees.putIfAbsent(ch, 0);
            }
        }

        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if(!updateRules(words[i], words[j], rules)){
                    return "";
                }
            }
        }

        for(Set<Character> neighbours : rules.values()) {
            for(char neigh : neighbours) {
                inDegrees.put(neigh, inDegrees.get(neigh) + 1);
            }
        }

        Deque<Character> queue = new ArrayDeque<>();
        for(Map.Entry<Character, Integer> entry : inDegrees.entrySet()) {
            if(entry.getValue() == 0) {
                queue.addLast(entry.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            char popped = queue.removeFirst();
            sb.append(popped);
            for(char neigh : rules.get(popped)) {
                inDegrees.put(neigh, inDegrees.get(neigh) - 1);
                if(inDegrees.get(neigh) == 0) {
                    queue.addLast(neigh);
                }
            }
        }

        return sb.length() == rules.size() ? sb.toString() : "";
    }

    private boolean updateRules(String word1, String word2, Map<Character, Set<Character>> rules) {
        int i = 0, j = 0;

        while(i < word1.length() && j < word2.length()) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(j);

            if(ch1 != ch2) {
                if(rules.get(ch2).contains(ch1)) {
                    return false;
                }

                rules.get(ch1).add(ch2);
                return true;
            }
            i++;
            j++;
        }
        return i == word1.length();
    }

    public static void main(String[] args) {
        AlienDictionary app = new AlienDictionary();
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(app.alienOrder(words));
        String[] words2 = {"z","x"};
        System.out.println(app.alienOrder(words2));
        String[] words3 = {"z","x","z"};
        System.out.println(app.alienOrder(words3));
        String[] words4 = {"abc","ab"};
        System.out.println(app.alienOrder(words4));

    }

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i=0; i<words.length; i++) {
            for (int j=i+1; j<words.length; j++) {
                if (!populateMap(words[i], words[j], map)) {
                    return "";
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            inDegree.put(entry.getKey(), entry.getValue().size());
            if (entry.getValue().isEmpty()) {
                queue.offer(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
                char key = entry.getKey();
                if (entry.getValue().contains(c)) {
                    inDegree.put(key, inDegree.get(key) - 1);
                    if (inDegree.get(key) == 0) {
                        queue.offer(key);
                    }
                }
            }
        }

        return sb.length() == map.size() ? sb.toString() : "";
    }

    private boolean populateMap(String w1, String w2, Map<Character, Set<Character>> map) {
        int i=0;
        while (i<w1.length() && i<w2.length()) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);
            if (c1 != c2) {
                map.get(c2).add(c1);
                return true;
            }
            i++;
        }

        return i == w1.length();
    }


}
