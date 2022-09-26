package fb_high_frequency;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i=m-1,j=n-1; i>=0 ||j>=0; i--,j--) {
            int n1 = i >= 0 ? num1.charAt(i)-'0' : 0;
            int n2 = j >= 0 ? num2.charAt(j)-'0' : 0;
            sb.append((n1+n2+carry)%10);
            carry = (n1 + n2 + carry)/10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
