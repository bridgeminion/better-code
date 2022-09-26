package string._273;


public class Solution {
    private static final String[] belowTen = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static final String[] belowHundred = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num < 10) {
            return belowTen[num];
        } else if (num < 20) {
            return belowTwenty[num - 10];
        } else if (num < 100) {
            return belowHundred[(num-20)/10] + (num % 10 == 0 ? "" : " " + numberToWords(num % 10));
        } else if (num < 1000) {
            return belowTen[num/100] + " Hundred" + (num % 100 == 0 ? "" : " " + numberToWords(num % 100));
        } else if (num < 1000000) {
            return numberToWords(num/1000) + " Thousand" + (num % 1000 == 0 ? "" : " " + numberToWords(num % 1000));
        } else if (num < 1000000000) {
            return numberToWords(num/1000000) + " Million" + (num % 1000000 == 0 ? "" : " " + numberToWords(num % 1000000));
        } else {
            return numberToWords(num/1000000000) + " Billion" + (num % 1000000000 == 0 ? "" : " " + numberToWords(num % 1000000000));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberToWords(1234567));
    }

}
