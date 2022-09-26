package top_interview_questions;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            counts[c-'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram instance = new ValidAnagram();
        System.out.println(instance.isAnagram("nl", "cx"));
    }

}
