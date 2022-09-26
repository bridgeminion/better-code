package top_interview_questions;

public class PlusOne {
    public int[] plusOne1(int[] digits) {
        int[] result = new int[digits.length];
        int carry = 1;
        for (int i=digits.length-1; i>=0; i--) {
            result[i] = (digits[i] + carry)%10;
            carry = (digits[i] + carry)/10;
        }
        if (carry == 1) {
            int[] result1 = new int[digits.length + 1];
            result1[0] = 1;
            for (int i=0; i<result.length; i++) {
                result1[i+1] = result[i];
            }
            return result1;
        }

        return result;
    }

    public int[] plusOne(int[] digits) {
        for (int i=digits.length - 1; i>=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //only applies if 999, 9999
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }

}
