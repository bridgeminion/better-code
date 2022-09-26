package top_interview_questions;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int j = 1;
        String prefix = "";
        while (j <= strs[0].length()) {
            for (int i=0; i<strs.length; i++) {
                if (i == 0) {
                    prefix = strs[i].substring(0, j);
                }
                if (!strs[i].startsWith(prefix)) {
                    return strs[i].substring(0, j-1);
                }
            }
            j++;
        }

        return "";
    }

    public static void main(String[] args) {
        LongestCommonPrefix instance = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println(instance.longestCommonPrefix(strs));
    }

}
