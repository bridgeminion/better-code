package top_interview_questions;

public class Trie {
    class TrieNode {
        TrieNode[] list;
        char value;
        boolean isWord;
        public TrieNode (char val) {
            this.value = val;
            list = new TrieNode[26];
        }
    }
    TrieNode head;
    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode('x');

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = head;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (temp.list[c-'a'] == null) {
                temp.list[c-'a'] = new TrieNode(c);
            }
            temp = temp.list[c-'a'];
        }
        temp.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = head;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (temp.list[c-'a'] == null) {
                return false;
            }
            temp = temp.list[c-'a'];
        }

        return temp.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = head;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (temp.list[c-'a'] == null) {
                return false;
            }
            temp = temp.list[c-'a'];
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

}
