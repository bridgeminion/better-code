package google_high_frequency;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        for (int i=num1.length()-1, j=num2.length()-1, carry=0; i>=0 || j>=0 || carry > 0; i--, j--) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            sb.insert(0, sum);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        AddStrings app = new AddStrings();
        System.out.println(app.addStrings("123", "45"));
    }
}
