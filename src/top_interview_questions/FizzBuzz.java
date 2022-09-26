package top_interview_questions;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            StringBuilder sb = new StringBuilder();
            if (n % 3 == 0) {
                sb.append("Fizz");
            }
            if (n % 5 == 0) {
                sb.append("Buzz");
            }
            result.add(sb.length() == 0 ? i+"" : sb.toString());
        }

        return result;

    }
}
