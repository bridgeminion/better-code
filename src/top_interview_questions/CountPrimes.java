package top_interview_questions;

import java.util.HashSet;
import java.util.Set;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        // since only even prime number is 2, start with 3 and i=i+2
        int count = n > 2 ? 1 : 0;
        for (int i=3; i<n; i=i+2) {
            if (!notPrimes[i]) {
                count++;
                for (int j=3; i*j<n; j=j+2) { // skip all even numbers
                    notPrimes[i*j] = true;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrimes instance = new CountPrimes();
        System.out.println(instance.countPrimes(10));
    }

}
