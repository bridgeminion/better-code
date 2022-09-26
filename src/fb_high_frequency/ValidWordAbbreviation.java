package fb_high_frequency;

import javax.swing.*;

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] w = word.toCharArray();
        char[] a = abbr.toCharArray();
        int i=0, j=0, num = 0;
        while (i<w.length && j<a.length) {
            char ac = a[j];
            if (Character.isLetter(ac)) {
                if (num != 0) {
                    i += num;
                    if (i >= w.length) {
                        return false;
                    }
                    num = 0;
                }
                if (ac != w[i]) {
                    return false;
                }
                i++;
                j++;
            } else {
                num = num*10 + ac-'0';
                if (num == 0) {
                    return false;
                }
                j++;
            }
        }
        if (i+num != w.length || j != a.length) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidWordAbbreviation app = new ValidWordAbbreviation();
        System.out.println(app.validWordAbbreviation("internationalization", "i5a11o1"));
    }

}
