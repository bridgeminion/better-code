package by_frequency_and_tag;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetter(c)) {
                if (c == '(') {
                    count++;
                } else {
                    count--;
                    if (count < 0) {

                    }
                }
            } else {
                sb.append(c);
            }
        }

        return null;
    }

}
