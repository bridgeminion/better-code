package contest;

public class Contest5747 {
    boolean isValid = false;
    public boolean splitString(String s) {
        helper(s, "", 0, 0);
        return isValid;
    }

    void helper(String s, String lastStr, int start, int count) {
        if (start == s.length() && count > 1) {
            isValid = true;
            return;
        }
        if (!isValid) {
            int i=1;
            while (i <= s.length() - start ) {
                String next = s.substring(start, start+i);
                try {
                    if (count == 0 || Long.parseLong(next) + 1 == Long.parseLong(lastStr)) {
                        helper(s, next, start+i, count+1);
                    }
                } catch (NumberFormatException e) {

                }
                i++;
            }
        }
     }

    public static void main(String[] args) {
        Contest5747 instance = new Contest5747();
        instance.splitString("1234");
    }

}
