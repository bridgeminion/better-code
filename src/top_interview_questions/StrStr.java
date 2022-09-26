package top_interview_questions;

/**
 * in case of compare two string, use [j] vs [i+j]
 * time limit exceeds
 */
public class StrStr {
    public int strStr1(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        for (int i=0; i<=haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = i;
                for (int j=0; j<needle.length(); j++) {
                    if (haystack.charAt(k) != needle.charAt(j)) {
                        break;
                    }
                    k++;
                }
                if (k == i + needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        for (int i=0; i<=haystack.length() - needle.length(); i++) {
            for (int j=0; j<needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }



}
